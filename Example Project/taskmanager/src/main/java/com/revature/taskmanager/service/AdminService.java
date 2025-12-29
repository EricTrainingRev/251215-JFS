package com.revature.taskmanager.service;

import com.revature.taskmanager.entity.Admin;
import com.revature.taskmanager.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    /*
        Instead of manually checking admin credentials we can query for an admin
        entity with the given username and password. If we get an admin back then
        we know the credentials are valid, otherwise they are not and the login
        request is rejected. Note this method only returns the admin, in the
        LoginService is where the actual determination of login success or
        failure will happen
     */
    public Optional<Admin> findAdminByCredentials(String username, String password){
        return adminRepository.findByUsernameAndPassword(username, password);
    }

}
