package com.bloomington.backend.service;

import com.bloomington.backend.model.GroupTask;
import com.bloomington.backend.model.GroupTaskAssignment;
import com.bloomington.backend.repository.GroupTaskAssignmentRepository;
import com.bloomington.backend.repository.GroupTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupTaskService {
    @Autowired
    private GroupTaskRepository groupTaskRepo;
    @Autowired
    private GroupTaskAssignmentRepository groupTaskAssignmentRepo;

    public GroupTask createGroupTask(GroupTask task) {
        return groupTaskRepo.save(task);
    }

    public Optional<GroupTask> getGroupTask(Long id) {
        return groupTaskRepo.findById(id);
    }

    public Optional<GroupTask> updateGroupTaskIfLeader(Long groupId, Long userId, GroupTask update) {
        Optional<GroupTaskAssignment> assignment = groupTaskAssignmentRepo.findByGroupTaskIdAndUserId(groupId, userId);
        if (assignment.isPresent() && "LEADER".equalsIgnoreCase(assignment.get().getRole())) {
            return groupTaskRepo.findById(groupId).map(gt -> {
                gt.setTitle(update.getTitle());
                gt.setDescription(update.getDescription());
                return groupTaskRepo.save(gt);
            });
        }
        return Optional.empty();
    }
}