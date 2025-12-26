package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String assetTag;

    private String assetType;

    private String model;

    private LocalDate purchaseDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "current_holder_id")
    private User currentHolder;

    private LocalDateTime createdAt;

    public Asset() {
    }

    public Asset(Long id, String assetTag, String assetType, String model,
                 LocalDate purchaseDate, String status,
                 User currentHolder, LocalDateTime createdAt) {
        this.id = id;
        this.assetTag = assetTag;
        this.assetType = assetType;
        this.model = model;
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.currentHolder = currentHolder;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "AVAILABLE";
        }
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    /* ===== GETTERS ===== */

    public Long getId() {
        return id;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public String getAssetType() {
        return assetType;
    }

    public String getModel() {
        return model;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public String getStatus() {
        return status;
    }

    public User getCurrentHolder() {
        return currentHolder;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /* ===== SETTERS (TESTS REQUIRE THESE) ===== */

    public void setId(Long id) {
        this.id = id;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCurrentHolder(User currentHolder) {
        this.currentHolder = currentHolder;
    }
}
