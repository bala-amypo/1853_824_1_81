package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
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
        if (role == null) {
            role = "USER";
        }
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    public User() {
    }

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

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }
    public String getRole() { return role; }
    public String getPassword() { return password; }

    public void setId(Long id) { this.id = id; }
    public void setPassword(String password) { this.password = password; }
}
