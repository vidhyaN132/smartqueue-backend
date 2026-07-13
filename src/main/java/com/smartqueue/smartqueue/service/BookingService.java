package com.smartqueue.smartqueue.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartqueue.smartqueue.dto.BookingRequest;
import com.smartqueue.smartqueue.entity.Appointment;
import com.smartqueue.smartqueue.entity.Token;
import com.smartqueue.smartqueue.repository.AppointmentRepository;
import com.smartqueue.smartqueue.repository.TokenRepository;
@Service
public class BookingService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private TokenRepository tokenRepository;
    public String bookAppointment(BookingRequest request) {
        // Create Appointment
        Appointment appointment = new Appointment();
        appointment.setUserId(request.getUserId());
        appointment.setQueueId(request.getQueueId());
        appointment.setAppointmentDate(request.getAppointmentDate());
        appointment.setAppointmentTime(request.getAppointmentTime());
        appointment.setStatus("BOOKED");
        appointmentRepository.save(appointment);
        // Create Token
        Token token = new Token();
        token.setUserId(request.getUserId());
        token.setQueueId(request.getQueueId());
        token.setTokenNumber((int) tokenRepository.count() + 1);
        token.setStatus("WAITING");
        tokenRepository.save(token);
        return "Appointment Booked Successfully. Token Number: " + token.getTokenNumber();
    }
}
