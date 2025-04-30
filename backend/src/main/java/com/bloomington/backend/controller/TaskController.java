package com.bloomington.backend.controller;


import com.bloomington.backend.model.Task;
import com.bloomington.backend.model.User;
import com.bloomington.backend.repository.UserRepository;
import com.bloomington.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @GetMapping("/user/{userId}")
    public List<Task> getUserTasks(@PathVariable Long userId) {
        return taskService.getTasksByUser(userId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updated) {
        return taskService.updateTask(id, updated)
                .map(ResponseEntity.ok())
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (taskService.deleteTask(id)) return ResponseEntity.ok().build();
        else return ResponseEntity.notFound().build();
    }
}
