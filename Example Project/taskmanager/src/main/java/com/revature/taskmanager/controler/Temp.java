package com.revature.taskmanager.controler;

import com.revature.taskmanager.entity.Admin;
import com.revature.taskmanager.entity.Client;
import com.revature.taskmanager.entity.Task;
import com.revature.taskmanager.repository.AdminRepository;
import com.revature.taskmanager.repository.ClientRepository;
import com.revature.taskmanager.repository.TaskRepository;
import com.revature.taskmanager.util.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    You can always use a temporary class to quickly test things in your code, just make
    sure to add it to your gitignore file so your experimenting is not being
    persisted in your repository.
*/

@RestController
public class Temp {

    @Autowired
    private JwtUtility jwtUtility;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/admin")
    public Admin createAdmin(@RequestBody Admin admin){
        return adminRepository.save(admin);
    }

    @PostMapping("/login")
    public TBD adminLogin(@RequestBody Admin admin){
        // todo: implement login
    }
    
    @GetMapping("/admin/thing")
    public TBD adminAction(){
        // TODO: get JWT token from request header and validate it
    }

    @PostMapping("/client")
    public Client createClient(@RequestBody Client client){
        return clientRepository.save(client);
    }

    @PostMapping("/task")
    public Task createTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @GetMapping("/task/{clientId}")
    public List<Task> getTasksByClient(@PathVariable String clientId){
        Client client = new Client();
        client.setEmail(clientId);
        return taskRepository.findByClient(client);
    }

}
