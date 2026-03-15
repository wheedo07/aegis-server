package kr.ourgram.aegis.db;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestLogRepository extends JpaRepository<RequestLog, Long> {
    Page<RequestLog> findAllByOrderByCreatedAtDesc(Pageable pageable);
}