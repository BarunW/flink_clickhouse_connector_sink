package sink;

import ru.ivi.opensource.flinkclickhousesink.ClickHouseSinkConverter;
import schema.PL;

public class PLConverter implements ClickHouseSinkConverter<PL> {

    @Override
    public String convert(PL pl) {
        StringBuilder builder = new StringBuilder();
        builder.append("(");

        // add a.str
        builder.append("'");
        builder.append(pl.getProgrammingLang());
        builder.append("', ");

        // add a.integer
        builder.append(" )");
        return builder.toString();
    }
}
