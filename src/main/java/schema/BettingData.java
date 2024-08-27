package schema;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"UserID", "Date", "HomeTeam", "AwayTeam", "Competition", "HomeWinOdds",
        "DrawOdds", "AwayWindOdds", "Over5GoalsOdds", "Under2GoalsOdds", "BettingAmount", "TransactionID"})

public class BettingData {

    @JsonProperty("UserID")
    private String UserId;

    @JsonProperty("Date")
    private String Date;

    @JsonProperty("HomeTeam")
    private String HomeTeam;

    @JsonProperty("AwayTeam")
    private String AwayTeam;

    @JsonProperty("Competition")
    private String Competition;

    @JsonProperty("HomeWinOdds")
    private String HomeWinOdds;

    @JsonProperty("DrawOdds")
    private String DrawOdds;

    @JsonProperty("AwayWinOdds")
    private String AwayWinOdds;

    @JsonProperty("Over5GoalsOdds")
    private String Over5GoalsOdds;

    @JsonProperty("Under2GoalsOdds")
    private String Under2GoalsOdds;

    @JsonProperty("BettingAmount")
    private String BettingAmount;

    @JsonProperty("TransactionID")
    private String TransactionID;

    // Getters
    public String getUserId() { return this.UserId; }
    public String getDate() { return this.Date; }
    public String getHomeTeam() { return this.HomeTeam; }
    public String getAwayTeam() { return this.AwayTeam; }
    public String getCompetition() { return this.Competition; }
    public String getHomeWinOdds() { return this.HomeWinOdds; }
    public String getDrawOdds() { return this.DrawOdds; }
    public String getAwayWinOdds() { return this.AwayWinOdds; }
    public String getOver5GoalsOdds() { return this.Over5GoalsOdds; }
    public String getUnder2GoalsOdds() { return this.Under2GoalsOdds; }
    public String getBettingAmount() { return this.BettingAmount; }
    public String getTransactionID() { return this.TransactionID; }

    // Setters
    public void setUserId(String userId) { this.UserId = userId; }
    public void setDate(String date) { this.Date = date; }
    public void setHomeTeam(String homeTeam) { this.HomeTeam = homeTeam; }
    public void setAwayTeam(String awayTeam) { this.AwayTeam = awayTeam; }
    public void setCompetition(String competition) { this.Competition = competition; }
    public void setHomeWinOdds(String homeWinOdds) { this.HomeWinOdds = homeWinOdds; }
    public void setDrawOdds(String drawOdds) { this.DrawOdds = drawOdds; }
    public void setAwayWinOdds(String awayWinOdds) { this.AwayWinOdds = awayWinOdds; }
    public void setOver5GoalsOdds(String over5GoalsOdds) { this.Over5GoalsOdds = over5GoalsOdds; }
    public void setUnder2GoalsOdds(String under2GoalsOdds) { this.Under2GoalsOdds = under2GoalsOdds; }
    public void setBettingAmount(String bettingAmount) { this.BettingAmount = bettingAmount; }
    public void setTransactionID(String transactionID) { this.TransactionID = transactionID; }
}


