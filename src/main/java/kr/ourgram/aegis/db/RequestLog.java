package kr.ourgram.aegis.db;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "request_log")
public class RequestLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }

    private String ip;
    public String getIp() {
        return ip;
    }
    public void setIp(String v) {
        this.ip = v;
    }

    private String uri;
    public String getUri() {
        return uri;
    }
    public void setUri(String v) {
        this.uri = v;
    }

    private String method;
    public String getMethod() {
        return method;
    }
    public void setMethod(String v) {
        this.method = v;
    }

    private String host;
    public String getHost() {
        return host;
    }
    public void setHost(String v) {
        this.host = v;
    }

    @Column(name = "user_agent")
    private String userAgent;
    public String getUserAgent() {
        return userAgent;
    }
    public void setUserAgent(String v) {
        this.userAgent = v;
    }

    @Column(nullable = false)
    private String action;  // ALLOW | BLOCK
    public String getAction() {
        return action;
    }
    public void setAction(String v) {
        this.action = v;
    }

    private String reason;
    public String getReason() {
        return reason;
    }
    public void setReason(String v) {
        this.reason = v;
    }

    private Long agentId;
    public Long getAgentId() {
        return agentId;
    }
    public void setAgentId(Long v) {
        this.agentId = v;
    }

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
