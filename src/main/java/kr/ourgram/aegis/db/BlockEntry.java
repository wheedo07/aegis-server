package kr.ourgram.aegis.db;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "block_entry")
public class BlockEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }

    @Column(nullable = false, unique = true)
    private String ip;
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }

    private String reason;
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    private LocalDateTime expiresAt;  // null = 영구 차단
    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }
    public void setExpiresAt(LocalDateTime v) {
        this.expiresAt = v;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}