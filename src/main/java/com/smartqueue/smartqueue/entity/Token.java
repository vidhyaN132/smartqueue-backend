package com.smartqueue.smartqueue.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "token")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int tokenNumber;
    private Long userId;
    private Long queueId;
    private String status;
    public Token() {
    }
    public Token(Long id, int tokenNumber, Long userId, Long queueId, String status) {
        this.id = id;
        this.tokenNumber = tokenNumber;
        this.userId = userId;
        this.queueId = queueId;
        this.status = status;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getTokenNumber() {
        return tokenNumber;
    }
    public void setTokenNumber(int tokenNumber) {
        this.tokenNumber = tokenNumber;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getQueueId() {
        return queueId;
    }
    public void setQueueId(Long queueId) {
        this.queueId = queueId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
