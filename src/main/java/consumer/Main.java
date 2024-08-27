package consumer;

import com.clickhouse.client.ClickHouseNode;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.core.fs.Path;
import org.apache.flink.formats.csv.CsvReaderFormat;
import org.apache.flink.connector.file.src.FileSource;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.function.SerializableFunction;

import ru.ivi.opensource.flinkclickhousesink.ClickHouseSink;
import ru.ivi.opensource.flinkclickhousesink.ClickHouseSinkConverter;
import ru.ivi.opensource.flinkclickhousesink.model.ClickHouseSinkConst;
import schema.BettingData;
import schema.PL;
import sink.BettingDataConverter;
import sink.PLConverter;

import java.util.Properties;

public class Main {
    public static void main(String[] args) throws  Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        env.getConfig().setGlobalJobParameters(sink.ParametersInit.Init());
        //pl(env);
        betting(env);
        env.execute("Whatever ");
    }

    public  static void betting(StreamExecutionEnvironment env){
        String filePath = "/home/dbarun/CDPG/betting_data.csv";

        SerializableFunction<CsvMapper, CsvSchema> schemaGenerator = mapper ->
                mapper.schemaFor(BettingData.class).withHeader().withSkipFirstDataRow(true).withoutColumns();

        CsvReaderFormat<BettingData> csvFormat =
                CsvReaderFormat.forSchema(CsvMapper::new, schemaGenerator, TypeInformation.of(BettingData.class));

        FileSource<BettingData> source = FileSource.forRecordStreamFormat(csvFormat, new Path(filePath)).build();
        final DataStreamSource<BettingData> gameDataStream =env.fromSource(source, WatermarkStrategy.noWatermarks(), "game data");

        gameDataStream.map(data -> {System.out.println(data); return  data;}).print();
        Properties props = new Properties();
        props.setProperty(ClickHouseSinkConst.TARGET_TABLE_NAME, "betting_data_");
        props.setProperty(ClickHouseSinkConst.MAX_BUFFER_SIZE, "10000");

        // Create and add the ClickHouse sink
        ClickHouseSinkConverter<BettingData> converter = new BettingDataConverter();
        ClickHouseSink<BettingData> clickHouseSink = new ClickHouseSink<>(props, converter);

        gameDataStream.addSink(clickHouseSink)
                .name("Betting Data ClickHouse Sink");

    }

    public  static void pl(StreamExecutionEnvironment env){
        String filePath = "/home/dbarun/CDPG/pl.csv";

        SerializableFunction<CsvMapper, CsvSchema> schemaGenerator = mapper ->
                mapper.schemaFor(schema.PL.class).withoutQuoteChar().withColumnSeparator(',').withHeader();

        CsvReaderFormat<schema.PL> csvFormat =
                CsvReaderFormat.forSchema(CsvMapper::new, schemaGenerator, TypeInformation.of(schema.PL.class));

        FileSource<schema.PL> source = FileSource.forRecordStreamFormat(csvFormat, new Path(filePath)).build();
        final DataStreamSource<schema.PL> gameDataStream =env.fromSource(source, WatermarkStrategy.noWatermarks(), "pl data");

        gameDataStream.map(data -> {System.out.println(data); return  data;}).print();
        Properties props = new Properties();
        props.setProperty(ClickHouseSinkConst.TARGET_TABLE_NAME, "pl_data");
        props.setProperty(ClickHouseSinkConst.MAX_BUFFER_SIZE, "10000");

        // Create and add the ClickHouse sink
        ClickHouseSinkConverter<PL> converter = new PLConverter();
        ClickHouseSink<PL> clickHouseSink = new ClickHouseSink<>(props, converter);

        gameDataStream.addSink(clickHouseSink)
                .name("PL ClickHouse Sink");

    }
}
