package com.revature.taskmanager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID taskId;
    @Column(name = "task_title", nullable = false)
    private String taskTitle;
    @Column(name = "task_description", nullable = false)
    private String taskDescription;
    @Column(name = "task_complete")
    private boolean taskComplete;
    @ManyToOne
    @JoinColumn(name = "email", nullable = false)
    private Client client;
}
