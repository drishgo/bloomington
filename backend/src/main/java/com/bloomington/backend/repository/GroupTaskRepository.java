package com.bloomington.backend.repository;
import com.bloomington.backend.model.GroupTask;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GroupTaskRepository extends JpaRepository<GroupTask, Long> {
}