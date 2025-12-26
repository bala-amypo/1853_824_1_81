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

    @PrePersist
    public void prePersist() {
        if (role == null) {
            role = "USER";
        }
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
    

    /* ===== REQUIRED GETTERS / SETTERS ===== */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {          // ✅ REQUIRED
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {  // ✅ REQUIRED
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) { // ✅ REQUIRED
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {          // ✅ REQUIRED
        return password;
    }

    public void setPassword(String password) { // ✅ REQUIRED
        this.password = password;
    }
}
