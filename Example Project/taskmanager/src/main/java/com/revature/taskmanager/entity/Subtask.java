package com.revature.taskmanager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "subtasks")
public class Subtask {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "subtask_id")
    private UUID subtaskId;
    @Column(name = "subtask_title")
    private String subtaskTitle;
    @Column(name = "subtask_description")
    private String subtaskDescription;
    @Column(name = "subtask_complete")
    private Boolean subtaskComplete;
    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;
}
