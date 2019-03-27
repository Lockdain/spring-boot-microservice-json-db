package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ClientId {

    @Id
    private long clientId;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Account> accounts;
}
