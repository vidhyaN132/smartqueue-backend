package com.smartqueue.smartqueue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartqueue.smartqueue.entity.Appointment;

import jakarta.transaction.Transactional;

public interface AppointmentRepository
        extends JpaRepository<Appointment, Long> {

    // Get user appointments
    List<Appointment> findByUserId(Long userId);

    // Waiting queue sorted by token
    List<Appointment> findByStatusOrderByTokenNumberAsc(String status);

    // Find current serving token
    Appointment findFirstByStatusOrderByTokenNumberAsc(String status);

    // Get last token number
    @Query("SELECT MAX(a.tokenNumber) FROM Appointment a")
    Integer findMaxTokenNumber();

    // Delete old appointment history
    @Modifying
    @Transactional
    @Query("DELETE FROM Appointment a WHERE a.appointmentDate < :today")
    void deleteHistory(@Param("today") String today);
long countByStatus(String status);
}