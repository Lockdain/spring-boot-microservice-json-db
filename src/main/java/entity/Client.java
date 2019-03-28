package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Client {
    @JsonProperty
    @Getter
    @Setter
    private String clientId;

    @JsonProperty
    @Getter
    @Setter
    private List<Pair> accounts;

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
