package dao;

import entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ClientRepository extends JpaRepository<Client, Serializable> {
}
