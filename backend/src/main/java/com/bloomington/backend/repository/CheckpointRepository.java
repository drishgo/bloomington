package com.bloomington.backend.repository;

import com.bloomington.backend.model.Checkpoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckpointRepository extends JpaRepository<Checkpoint, Long> {
}