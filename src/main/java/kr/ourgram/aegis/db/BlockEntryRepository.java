package kr.ourgram.aegis.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

public interface BlockEntryRepository extends JpaRepository<BlockEntry, Long> {
    Optional<BlockEntry> findByIp(String ip);
    boolean existsByIp(String ip);

    @Transactional
    void deleteByIp(String ip);
}
