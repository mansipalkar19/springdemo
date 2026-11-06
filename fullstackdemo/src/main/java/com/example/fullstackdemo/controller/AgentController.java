package com.example.fullstackdemo.controller;

import com.example.fullstackdemo.model.Agent;
import com.example.fullstackdemo.repo.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class AgentController {

    @Autowired
    private AgentRepository agentRepository;
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Agent agent)
    {
        if(agentRepository.findByEmail(agent.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body("Email already Exist");
        }

        Agent agentuser=agentRepository.save(agent);
        return new ResponseEntity<>(agentuser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> loginData)
    {
        String email=loginData.get("email");
        String password=loginData.get("password");

        Optional<Agent> useropt=agentRepository.findByEmail(email);
        if(useropt.isPresent() && useropt.get().getPassword().equals(password)){
            return ResponseEntity.ok("successful");
        }
        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }
}
