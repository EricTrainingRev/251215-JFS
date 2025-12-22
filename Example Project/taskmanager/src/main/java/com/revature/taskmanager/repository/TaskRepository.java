package com.revature.taskmanager.repository;

import com.revature.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    /*
        Instead of searching through all the tasks in the Java code to find the tasks
        specific for a user, we can instead query the database for the filtered data
        directly. Spring Data JPA provides an API for doing this, following a specific
        naming convention. More detail on this can be found here:
        https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#jpa.query-methods.query-creation
     */
    List<Task> findByEmail(String email);
}
