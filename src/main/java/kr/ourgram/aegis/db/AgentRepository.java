package kr.ourgram.aegis.db;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AgentRepository extends JpaRepository<AgentEntity, Long> {
    Optional<AgentEntity> findByHost(String host);
}
