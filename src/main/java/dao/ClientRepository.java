package dao;

import entity.ClientId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ClientRepository extends JpaRepository<ClientId, Serializable> {
}
