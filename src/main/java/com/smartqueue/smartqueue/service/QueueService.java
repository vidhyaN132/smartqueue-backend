package com.smartqueue.smartqueue.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartqueue.smartqueue.entity.QueueEntity;
import com.smartqueue.smartqueue.repository.QueueRepository;
@Service
public class QueueService {
    @Autowired
    private QueueRepository queueRepository;
    // Add Queue
    public QueueEntity addQueue(QueueEntity queue) {
        return queueRepository.save(queue);
    }
    // Get All Queues
    public List<QueueEntity> getAllQueues() {
        return queueRepository.findAll();
    }
    // Get Queue By ID
    public QueueEntity getQueueById(Long id) {
        return queueRepository.findById(id).orElse(null);
    }
    // Get Live Queue Status
    public QueueEntity getQueueStatus(Long id) {
        return queueRepository.findById(id).orElse(null);
    }
    // Update Queue
    public QueueEntity updateQueue(Long id, QueueEntity queueDetails) {
        QueueEntity queue = queueRepository.findById(id).orElse(null);
        if (queue != null) {
            queue.setQueueName(queueDetails.getQueueName());
            queue.setDepartment(queueDetails.getDepartment());
            queue.setCurrentToken(queueDetails.getCurrentToken());
            queue.setTotalPeople(queueDetails.getTotalPeople());
            queue.setAverageServiceTime(queueDetails.getAverageServiceTime());
            queue.setStatus(queueDetails.getStatus());
            return queueRepository.save(queue);
        }
            return null;
    }
    // Delete Queue
    public String deleteQueue(Long id) {
        queueRepository.deleteById(id);
        return "Queue deleted successfully";
    }
}