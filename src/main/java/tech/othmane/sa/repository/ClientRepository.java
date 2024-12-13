package tech.othmane.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.othmane.sa.entites.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
