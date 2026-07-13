package com.smartqueue.smartqueue.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartqueue.smartqueue.entity.Appointment;
import com.smartqueue.smartqueue.repository.AppointmentRepository;
import java.util.Map;
import java.util.HashMap;
@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Create Appointment + Generate Token
    public Appointment saveAppointment(Appointment appointment) {

        if (appointment.getId() == null) {

            Integer lastToken = appointmentRepository.findMaxTokenNumber();

            int newToken = 1;

            if (lastToken != null) {
                newToken = lastToken + 1;
            }

            appointment.setTokenNumber(newToken);

            if (appointment.getStatus() == null ||
                    appointment.getStatus().isEmpty()) {

                appointment.setStatus("WAITING");
            }
        }

        return appointmentRepository.save(appointment);
    }

    // Get All Appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Get Appointment By ID
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository
                .findById(id)
                .orElse(null);
    }

    // Get User Appointments
    public List<Appointment> getAppointmentsByUserId(Long userId) {
        return appointmentRepository.findByUserId(userId);
    }

    // Update Appointment
    public Appointment updateAppointment(Long id, Appointment appointment) {

        Appointment oldAppointment = appointmentRepository
                .findById(id)
                .orElse(null);

        if (oldAppointment != null) {

            oldAppointment.setDepartment(
                    appointment.getDepartment());

            oldAppointment.setAppointmentDate(
                    appointment.getAppointmentDate());

            oldAppointment.setAppointmentTime(
                    appointment.getAppointmentTime());

            oldAppointment.setStatus(
                    appointment.getStatus());

            return appointmentRepository.save(oldAppointment);
        }

        return null;
    }

    // Cancel Appointment
    public Appointment cancelAppointment(Long id) {

        Appointment appointment = appointmentRepository
                .findById(id)
                .orElse(null);

        if (appointment != null) {

            appointment.setStatus("CANCELLED");

            return appointmentRepository.save(appointment);
        }

        return null;
    }
    // Update Appointment Status
public Appointment updateStatus(Long id, String status) {

    Appointment appointment = appointmentRepository
            .findById(id)
            .orElse(null);

    if (appointment != null) {

        appointment.setStatus(status);

        return appointmentRepository.save(appointment);
    }

    return null;
}

    // Delete Appointment
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    // Delete History (Before Today)
    @Transactional
    public void deleteHistory() {

        String today = LocalDate.now().toString();

        appointmentRepository.deleteHistory(today);
    }

    // Waiting Queue
    public List<Appointment> getWaitingQueue() {

        return appointmentRepository
                .findByStatusOrderByTokenNumberAsc("WAITING");
    }

    // Current Serving Token
    public Appointment getCurrentServingToken() {

        return appointmentRepository
                .findFirstByStatusOrderByTokenNumberAsc("SERVING");
    }

    // Admin Call Next Token
    @Transactional
    public Appointment callNextToken() {

        Appointment current = appointmentRepository
                .findFirstByStatusOrderByTokenNumberAsc("SERVING");

        if (current != null) {

            current.setStatus("COMPLETED");

            appointmentRepository.save(current);
        }

        Appointment next = appointmentRepository
                .findFirstByStatusOrderByTokenNumberAsc("WAITING");

        if (next != null) {

            next.setStatus("SERVING");

            return appointmentRepository.save(next);
        }

        return null;
    }

    // Complete Current Token
    @Transactional
    public Appointment completeCurrentToken() {

        Appointment current = appointmentRepository
                .findFirstByStatusOrderByTokenNumberAsc("SERVING");

        if (current != null) {

            current.setStatus("COMPLETED");

            return appointmentRepository.save(current);
        }

        return null;
    }
// Admin Dashboard Statistics
public Map<String, Long> getDashboardStats() {

    Map<String, Long> stats = new HashMap<>();

    stats.put(
        "total",
        appointmentRepository.count()
    );

    stats.put(
        "waiting",
        appointmentRepository.countByStatus("WAITING")
    );

    stats.put(
        "serving",
        appointmentRepository.countByStatus("SERVING")
    );

    stats.put(
        "completed",
        appointmentRepository.countByStatus("COMPLETED")
    );

    stats.put(
        "cancelled",
        appointmentRepository.countByStatus("CANCELLED")
    );

    return stats;
}
}