package kr.ourgram.aegis.db;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "agent")
public class AgentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }

    @Column(nullable = false, unique = true)
    private String host;
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    private String status = "ACTIVE";
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    private LocalDateTime lastSeen;
    public LocalDateTime getLastSeen() {
        return lastSeen;
    }
    public void setLastSeen(LocalDateTime v) {
        this.lastSeen = v;
    }

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        lastSeen = createdAt;
    }
}