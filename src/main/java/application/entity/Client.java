package application.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Client {

    @JsonProperty("ClientId")
    @Getter
    @Setter
    @Id
    private long clientId;

    @JsonProperty("Accounts")
    @OneToMany(targetEntity = Pair.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Pair> accounts;

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
