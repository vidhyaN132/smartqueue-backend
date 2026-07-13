package com.smartqueue.smartqueue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.smartqueue.smartqueue.entity.QueueEntity;
import com.smartqueue.smartqueue.service.QueueService;


@RestController
@RequestMapping("/queues")
@CrossOrigin(origins = "http://localhost:3000")
public class QueueController {


    @Autowired
    private QueueService queueService;



    // Get All Queues
    @GetMapping
    public List<QueueEntity> getAllQueues(){

        return queueService.getAllQueues();

    }



    // Add Queue
    @PostMapping
    public QueueEntity addQueue(
            @RequestBody QueueEntity queue
    ){

        return queueService.addQueue(queue);

    }



    // Get Queue By ID
    @GetMapping("/{id}")
    public QueueEntity getQueueById(
            @PathVariable Long id
    ){

        return queueService.getQueueById(id);

    }



    // Update Queue
    @PutMapping("/{id}")
    public QueueEntity updateQueue(
            @PathVariable Long id,
            @RequestBody QueueEntity queue
    ){

        return queueService.updateQueue(id, queue);

    }



    // Delete Queue
    @DeleteMapping("/{id}")
    public String deleteQueue(
            @PathVariable Long id
    ){

        return queueService.deleteQueue(id);

    }

}