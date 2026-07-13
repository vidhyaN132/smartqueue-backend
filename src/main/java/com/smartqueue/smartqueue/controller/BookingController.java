package com.smartqueue.smartqueue.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.smartqueue.smartqueue.dto.BookingRequest;
import com.smartqueue.smartqueue.service.BookingService;
@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping
    public String bookAppointment(@RequestBody BookingRequest request) {
        return bookingService.bookAppointment(request);
    }
}
