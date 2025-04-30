package com.bloomington.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class ActivityLog {
    @Id
    @GeneratedValue
    private Long id;
    private String action;
    private LocalDateTime timestamp;

    @ManyToOne
    private User actor;

    @ManyToOne
    private GroupTask groupTask;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public User getActor() {
        return actor;
    }

    public void setActor(User actor) {
        this.actor = actor;
    }

    public GroupTask getGroupTask() {
        return groupTask;
    }

    public void setGroupTask(GroupTask groupTask) {
        this.groupTask = groupTask;
    }
}