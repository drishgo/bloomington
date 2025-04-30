package com.bloomington.backend.repository;
import com.bloomington.backend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CommentRepository extends JpaRepository<Comment, Long> {
}