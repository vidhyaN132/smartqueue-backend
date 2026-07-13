package com.smartqueue.smartqueue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartqueue.smartqueue.entity.QueueEntity;

public interface QueueRepository 
extends JpaRepository<QueueEntity, Long> {

}
