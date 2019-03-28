package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Client {
    @JsonProperty
    private String clientId;

    @JsonProperty
    private List<Pair> accounts;

    public String getСlientId() {
        return clientId;
    }

    public void setСlientId(String сlientId) {
        clientId = сlientId;
    }

    public List<Pair> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Pair> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
