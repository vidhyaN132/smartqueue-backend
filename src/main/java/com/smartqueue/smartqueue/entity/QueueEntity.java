package com.smartqueue.smartqueue.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "queue")
public class QueueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String queueName;
    private String department;
    private int currentToken;
    private int totalPeople;
    private int averageServiceTime;
    private String status;
    // Default Constructor
    public QueueEntity() {
    }
    // Parameterized Constructor
    public QueueEntity(String queueName, String department, int currentToken,
                       int totalPeople, int averageServiceTime, String status) {
        this.queueName = queueName;
        this.department = department;
        this.currentToken = currentToken;
        this.totalPeople = totalPeople;
        this.averageServiceTime = averageServiceTime;
        this.status = status;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getQueueName() {
        return queueName;
    }
    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public int getCurrentToken() {
        return currentToken;
    }
    public void setCurrentToken(int currentToken) {
        this.currentToken = currentToken;
    }
    public int getTotalPeople() {
        return totalPeople;
    }
    public void setTotalPeople(int totalPeople) {
        this.totalPeople = totalPeople;
    }
    public int getAverageServiceTime() {
        return averageServiceTime;
    }
    public void setAverageServiceTime(int averageServiceTime) {
        this.averageServiceTime = averageServiceTime;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}