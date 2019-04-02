package application.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pair {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @JsonProperty("account")
    @Getter
    @Setter
    private String account;

    @JsonProperty("balance")
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
