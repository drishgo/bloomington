package com.bloomington.backend.service;
import com.bloomington.backend.model.GroupTask;
import com.bloomington.backend.model.GroupTaskAssignment;
import com.bloomington.backend.model.Task;
import com.bloomington.backend.repository.GroupTaskAssignmentRepository;
import com.bloomington.backend.repository.GroupTaskRepository;
import com.bloomington.backend.repository.TaskRepository;
import com.bloomington.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepo;
    @Autowired
    private UserRepository userRepo;

    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    public List<Task> getTasksByUser(Long userId) {
        return taskRepo.findAll().stream()
                .filter(task -> task.getOwner().getId().equals(userId))
                .collect(Collectors.toList());
    }

    public Optional<Task> updateTask(Long id, Task update) {
        return taskRepo.findById(id).map(task -> {
            task.setTitle(update.getTitle());
            task.setDescription(update.getDescription());
            task.setCompleted(update.isCompleted());
            task.setPriority(update.getPriority());
            task.setLabels(update.getLabels());
            task.setDueDate(update.getDueDate());
            task.setCheckpoints(update.getCheckpoints());
            return taskRepo.save(task);
        });
    }

    public boolean deleteTask(Long id) {
        return taskRepo.findById(id).map(task -> {
            taskRepo.delete(task);
            return true;
        }).orElse(false);
    }
}
