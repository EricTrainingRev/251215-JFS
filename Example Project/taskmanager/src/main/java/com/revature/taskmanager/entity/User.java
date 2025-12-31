package com.revature.taskmanager.entity;

import com.revature.taskmanager.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;
    @Column
    private String username;
    @Column
    private String password;
    @Enumerated(EnumType.STRING)
    @Column
    private UserRole role;
}
