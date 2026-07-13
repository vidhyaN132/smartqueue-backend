package com.smartqueue.smartqueue.dto;
public class BookingRequest {
    private Long userId;
    private Long queueId;
    private String appointmentDate;
    private String appointmentTime;
    public BookingRequest() {
    }
    public BookingRequest(Long userId, Long queueId, String appointmentDate, String appointmentTime) {
        this.userId = userId;
        this.queueId = queueId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
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
}
