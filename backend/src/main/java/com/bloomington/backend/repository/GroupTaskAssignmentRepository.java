package com.bloomington.backend.repository;

import com.bloomington.backend.model.GroupTaskAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupTaskAssignmentRepository extends JpaRepository<GroupTaskAssignment, Long> {
    Optional<GroupTaskAssignment> findByGroupTaskIdAndUserId(Long groupTaskId, Long userId);
}