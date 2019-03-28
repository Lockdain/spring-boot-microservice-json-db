package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Pair {
    @JsonProperty
    @Getter
    @Setter
    private String account;

    @JsonProperty
    @Getter
    @Setter
    private String balance;

    @Override
    public String toString() {
        return "Pair{" +
                "account='" + account + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
