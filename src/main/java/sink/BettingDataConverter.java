package sink;

import ru.ivi.opensource.flinkclickhousesink.ClickHouseSinkConverter;
import schema.BettingData;

public class BettingDataConverter implements ClickHouseSinkConverter<BettingData> {
    @Override
    public String convert(BettingData data) {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        builder.append(quoteString(data.getUserId())).append(", ");
        builder.append(quoteString(data.getDate())).append(", ");
        builder.append(quoteString(data.getHomeTeam())).append(", ");
        builder.append(quoteString(data.getAwayTeam())).append(", ");
        builder.append(quoteString(data.getCompetition())).append(", ");
        builder.append(data.getHomeWinOdds()).append(", ");
        builder.append(data.getDrawOdds()).append(", ");
        builder.append(data.getAwayWinOdds()).append(", ");
        builder.append(data.getOver5GoalsOdds()).append(", ");
        builder.append(data.getUnder2GoalsOdds()).append(", ");
        builder.append(data.getBettingAmount()).append(", ");
        builder.append(quoteString(data.getTransactionID()));
        builder.append(")");
        return builder.toString();
    }

    private String quoteString(String s) {
        return "'" + s.replace("'", "\\'") + "'";
    }
}