


package com.example.demo.repository;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "assets")
public class Asset{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "asset_tag", nullable = false, unique = true)
    private String assetTag;

    @Column(name = "asset_type", nullable = false)
    private String assetType;

    @Column(nullable = false)
    private String model;

    private LocalDate purchaseDate;

    @Column(nullable = false)
    private String status;

    @Column(name = "current_holder")
    private String currentHolder;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

   
    @PrePersist
    public void onCreate() {
        if (purchaseDate == null) {
            purchaseDate = LocalDate.now();
        }
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (status == null) {
            status = "AVAILABLE";
        }
    }

   
    public Asset() {
    }

    public Asset(String assetTag, String assetType, String model,
                       LocalDate purchaseDate, String status,
                       String currentHolder) {
        this.assetTag = assetTag;
        this.assetType = assetType;
        this.model = model;
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.currentHolder = currentHolder;
    }


    public Long getId() {
        return id;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentHolder() {
        return currentHolder;
    }

    public void setCurrentHolder(String currentHolder) {
        this.currentHolder = currentHolder;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
