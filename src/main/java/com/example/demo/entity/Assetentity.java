package com.example.demo.repository;
 import jakarta.persistence.Entity;
 import jakarta.persistence.Id; 
 import jakarta.persistence.GeneratedValue; 
 import jakarta.persistence.GenerationType;
 import jakarta.persistence.JoinColumn;
 import java.time.LocalDate;
 import java.time.LocalDateTime;
 
@Entity
public class Assetentity {
    private Long id;
    private String assetTag;
    private String assetType;
    private String model;
    private String purchaseDate;
    private String status;
    private String currentHolder;
    private String createdAt;
    public void ValidateAndInitializer() {
        this.purchaseDate = LocAL
    }

    @PrePersist
    public void onCreate() {

    }
}    