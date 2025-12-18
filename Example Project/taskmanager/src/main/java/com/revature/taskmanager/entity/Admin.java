package com.revature.taskmanager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/*
    Here we are going to use lombok to generate our Java Bean resources:
    - getter and setter methods for each field
    - no args and full args constructors
    - overridden toString, equals, and hashcode

    Note that we had to include the NoArgsConstructor annotation to also get the
    no args constructor
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "admins")
public class Admin {

    /*
        UUID is a randomly generated value that can be used to identify an entity. The
        odds of two UUIDs being the same are astronomically low, so it is a reasonable
        option when you need to generate unique identifiers
     */

    @Id
    @Column(name = "admin_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID adminID;
    @Column
    private String username;
    @Column
    private String password;

}
