package com.smartqueue.smartqueue.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.smartqueue.smartqueue.entity.Admin;
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
}