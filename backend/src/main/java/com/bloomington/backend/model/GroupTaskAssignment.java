package com.bloomington.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
public class GroupTaskAssignment {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private GroupTask groupTask;

    @ManyToOne
    private User user;

    private String role; // LEADER, MEMBER, VIEWER

    @OneToMany(cascade = CascadeType.ALL)
    private List<Checkpoint> checkpoints = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GroupTask getGroupTask() {
        return groupTask;
    }

    public void setGroupTask(GroupTask groupTask) {
        this.groupTask = groupTask;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(List<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }
}