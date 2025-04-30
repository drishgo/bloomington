package com.bloomington.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class GroupTask {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "groupTask", cascade = CascadeType.ALL)
    private List<GroupTaskAssignment> assignments = new ArrayList<>();

    @OneToMany(mappedBy = "groupTask", cascade = CascadeType.ALL)
    private List<ActivityLog> logs = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GroupTaskAssignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<GroupTaskAssignment> assignments) {
        this.assignments = assignments;
    }

    public List<ActivityLog> getLogs() {
        return logs;
    }

    public void setLogs(List<ActivityLog> logs) {
        this.logs = logs;
    }
}