package com.revature.taskmanager.repository;

import com.revature.taskmanager.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/*
    The JpaRepository interface requires two generics:
    1. the entity being managed
    2. the primary key type for the entity

    Once we have added this information, our repository is ready for use! If we only
    need basic CRUD functionality we are good to go, if we ever need to add custom
    non-basic CRUD queries we can add them here
*/
@Repository
public interface AdminRepository extends JpaRepository<Admin, UUID> {
    Optional<Admin> findByUsernameAndPassword(String username, String password);
}
