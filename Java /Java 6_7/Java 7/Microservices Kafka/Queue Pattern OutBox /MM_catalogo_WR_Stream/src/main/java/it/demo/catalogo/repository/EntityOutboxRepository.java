package it.demo.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.demo.catalogo.entity.EntityOutbox;

@Repository
public interface EntityOutboxRepository extends JpaRepository<EntityOutbox, Integer> {
    
    
    @Query(value = "SELECT * FROM event_outbox WHERE stato = 'PENDING' FOR UPDATE", nativeQuery = true)
    List<EntityOutbox> findPendingForUpdate();
    
}