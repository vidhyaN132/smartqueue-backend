package com.smartqueue.smartqueue.controller;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smartqueue.smartqueue.repository.UserRepository;
import com.smartqueue.smartqueue.repository.QueueRepository;
import com.smartqueue.smartqueue.repository.TokenRepository;
import com.smartqueue.smartqueue.repository.AppointmentRepository;
@RestController
public class DashboardController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QueueRepository queueRepository;
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @GetMapping("/dashboard")
    public Map<String, Long> getDashboard() {
        Map<String, Long> dashboard = new HashMap<>();
        dashboard.put("Total Users", userRepository.count());
        dashboard.put("Total Queues", queueRepository.count());
        dashboard.put("Total Tokens", tokenRepository.count());
        dashboard.put("Total Appointments", appointmentRepository.count());
        return dashboard;
    }
}