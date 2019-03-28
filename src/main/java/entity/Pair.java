package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pair {
    @JsonProperty
    private String account;

    @JsonProperty
    private String balance;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "account='" + account + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
