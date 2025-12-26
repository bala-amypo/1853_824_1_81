package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String department;
    private String role;
    private String password;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (role == null) role = "USER";
        createdAt = LocalDateTime.now();
    }

    public User() {}

    public User(Long id, String name, String email, String department,
                String role, String password, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.role = role;
        this.password = password;
        this.createdAt = createdAt;
    }

    // getters
    public Long getId() { return id; }
    public String getRole() { return role; }
    public String getDepartment() { return department; }
}
