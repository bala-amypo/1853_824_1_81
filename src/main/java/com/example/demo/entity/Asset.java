package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assetTag;
    private String assetType;
    private String model;
    private LocalDate purchaseDate;
    private String status;

    @ManyToOne
    private User currentHolder;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (status == null) status = "AVAILABLE";
        createdAt = LocalDateTime.now();
    }

    public Asset() {}

    public Asset(Long id, String assetTag, String assetType, String model,
                 LocalDate purchaseDate, String status, User currentHolder,
                 LocalDateTime createdAt) {
        this.id = id;
        this.assetTag = assetTag;
        this.assetType = assetType;
        this.model = model;
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.currentHolder = currentHolder;
        this.createdAt = createdAt;
    }

    // getters & setters (ALL REQUIRED)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAssetTag() { return assetTag; }
    public void setAssetTag(String assetTag) { this.assetTag = assetTag; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public User getCurrentHolder() { return currentHolder; }
    public void setCurrentHolder(User currentHolder) { this.currentHolder = currentHolder; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
