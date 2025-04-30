package com.bloomington.backend.controller;

import com.bloomington.backend.model.GroupTask;
import com.bloomington.backend.model.GroupTaskAssignment;
import com.bloomington.backend.model.Task;
import com.bloomington.backend.model.User;
import com.bloomington.backend.repository.UserRepository;
import com.bloomington.backend.service.GroupTaskService;
import com.bloomington.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/group")
public class GroupTaskController {
    @Autowired
    private GroupTaskService groupTaskService;

    @PostMapping("/create")
    public ResponseEntity<GroupTask> createGroupTask(@RequestBody GroupTask task) {

        return ResponseEntity.ok(groupTaskService.createGroupTask(task));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupTask> getGroupTask(@PathVariable Long id) {
        return ResponseEntity.of(groupTaskService.getGroupTask(id));
    }

    @PutMapping("/update/{groupId}/user/{userId}")
    public ResponseEntity<GroupTask> updateGroupTask(@PathVariable Long groupId, @PathVariable Long userId, @RequestBody GroupTask update) {
        return groupTaskService.updateGroupTaskIfLeader(groupId, userId, update)
                .map(ResponseEntity.ok())
                .orElse(ResponseEntity.status(HttpStatus.FORBIDDEN).build());
    }
}
