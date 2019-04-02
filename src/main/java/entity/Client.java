package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Client {

    @JsonProperty("ClientId")
    @Id
    @Getter
    @Setter
    private String clientId;

    @JsonProperty("Accounts")
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
