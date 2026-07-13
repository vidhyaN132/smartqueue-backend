package com.smartqueue.smartqueue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smartqueue.smartqueue.entity.Appointment;
import com.smartqueue.smartqueue.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "http://localhost:5173")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;


    // Create Appointment
    @PostMapping
    public ResponseEntity<Appointment> createAppointment(
            @RequestBody Appointment appointment) {

        return ResponseEntity.ok(
                appointmentService.saveAppointment(appointment)
        );
    }


    // Get All Appointments
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {

        return ResponseEntity.ok(
                appointmentService.getAllAppointments()
        );
    }


    // Get Appointment By ID
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(
            @PathVariable Long id) {

        Appointment appointment =
                appointmentService.getAppointmentById(id);

        if (appointment != null) {
            return ResponseEntity.ok(appointment);
        }

        return ResponseEntity.notFound().build();
    }


    // Get User Appointments
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Appointment>> getUserAppointments(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                appointmentService.getAppointmentsByUserId(userId)
        );
    }


    // Waiting Queue
    @GetMapping("/waiting")
    public ResponseEntity<List<Appointment>> getWaitingQueue() {

        return ResponseEntity.ok(
                appointmentService.getWaitingQueue()
        );
    }


    // Current Serving Token
    @GetMapping("/serving")
    public ResponseEntity<Appointment> getCurrentServingToken() {

        Appointment appointment =
                appointmentService.getCurrentServingToken();

        if (appointment != null) {
            return ResponseEntity.ok(appointment);
        }

        return ResponseEntity.noContent().build();
    }


    // Call Next Token
    @PutMapping("/next")
    public ResponseEntity<Appointment> callNextToken() {

        Appointment appointment =
                appointmentService.callNextToken();

        if (appointment != null) {
            return ResponseEntity.ok(appointment);
        }

        return ResponseEntity.noContent().build();
    }


    // Complete Token
    @PutMapping("/complete")
    public ResponseEntity<Appointment> completeToken() {

        Appointment appointment =
                appointmentService.completeCurrentToken();

        if (appointment != null) {
            return ResponseEntity.ok(appointment);
        }

        return ResponseEntity.noContent().build();
    }


    // Cancel Appointment (Existing API)
    @PutMapping("/cancel/{id}")
    public ResponseEntity<Appointment> cancelAppointment(
            @PathVariable Long id) {

        Appointment appointment =
                appointmentService.cancelAppointment(id);

        if (appointment != null) {
            return ResponseEntity.ok(appointment);
        }

        return ResponseEntity.notFound().build();
    }


    // Update Appointment Status API
    // Used by React: /appointments/status/{id}?status=CANCELLED
    @PutMapping("/status/{id}")
    public ResponseEntity<Appointment> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {


        Appointment appointment =
                appointmentService.updateStatus(id, status);


        if (appointment != null) {
            return ResponseEntity.ok(appointment);
        }


        return ResponseEntity.notFound().build();
    }



    // Delete Single Appointment
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(
            @PathVariable Long id) {

        appointmentService.deleteAppointment(id);

        return ResponseEntity.ok(
                "Appointment Deleted Successfully"
        );
    }


    // Delete History
    @DeleteMapping("/history")
    public ResponseEntity<String> deleteHistory() {

        appointmentService.deleteHistory();

        return ResponseEntity.ok(
                "Old appointment history deleted successfully."
        );
    }

}