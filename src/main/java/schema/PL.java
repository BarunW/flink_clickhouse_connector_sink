package schema;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"ProgrammingLang"})
public class PL {
    @JsonProperty("ProgrammingLang")
    private String ProgrammingLang;

    public String getProgrammingLang() {
        return ProgrammingLang;
    }

    public void setProgrammingLang(String lang){
        this.ProgrammingLang = lang;
    }
}
