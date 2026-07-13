package com.smartqueue.smartqueue.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long queueId;

    @Column(nullable = false)
    private Integer tokenNumber;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String appointmentDate;

    @Column(nullable = false)
    private String appointmentTime;

    @Column(nullable = false)
    private String status;

    public Appointment() {
    }

    public Appointment(Long id,
                       Long userId,
                       Long queueId,
                       Integer tokenNumber,
                       String department,
                       String appointmentDate,
                       String appointmentTime,
                       String status) {

        this.id = id;
        this.userId = userId;
        this.queueId = queueId;
        this.tokenNumber = tokenNumber;
        this.department = department;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getTokenNumber() {
        return tokenNumber;
    }

    public void setTokenNumber(Integer tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}