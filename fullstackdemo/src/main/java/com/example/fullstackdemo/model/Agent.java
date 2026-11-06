package com.example.fullstackdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="agent")
@Data
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true,nullable = false)
    private String email;
    private String name;
    @Column(nullable = false)
    private String password;
}
