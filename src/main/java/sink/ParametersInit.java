package sink;

import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.connector.clickhouse.config.ClickHouseConfig;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import ru.ivi.opensource.flinkclickhousesink.model.ClickHouseClusterSettings;
import ru.ivi.opensource.flinkclickhousesink.model.ClickHouseSinkConst;

import java.util.HashMap;
import java.util.Map;

public class ParametersInit {
    public static ParameterTool Init(){
        Map<String, String> globalParameters = new HashMap<>();

        globalParameters.put(ClickHouseClusterSettings.CLICKHOUSE_HOSTS, "http://localhost:8123");
        globalParameters.put(ClickHouseClusterSettings.CLICKHOUSE_USER, "default");
        globalParameters.put(ClickHouseClusterSettings.CLICKHOUSE_PASSWORD, "");
        globalParameters.put(ClickHouseSinkConst.TIMEOUT_SEC, "5");
        globalParameters.put(ClickHouseSinkConst.FAILED_RECORDS_PATH, "/home/dbarun/CDPG");
        globalParameters.put(ClickHouseSinkConst.NUM_WRITERS, "3");
        globalParameters.put(ClickHouseSinkConst.NUM_RETRIES, "1");
        globalParameters.put(ClickHouseSinkConst.QUEUE_MAX_CAPACITY, "20000");
        globalParameters.put(ClickHouseSinkConst.IGNORING_CLICKHOUSE_SENDING_EXCEPTION_ENABLED, "false");

        return ParameterTool.fromMap(globalParameters);
    }

}
