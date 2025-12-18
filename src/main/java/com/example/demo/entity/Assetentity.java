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
        this.purchaseDate = LocalDate.now();
        this.createdAt = LocalDateTime.now();
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = new Timestamp(System.LocalDateTime.now());
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public class Assetentity {
        this.purchaseDate = LocalDate.now();
        this. createdAt = LocalDateTime.now();
        this.createdAt = new Timestamp(System.LocalDateTime.now());
        this.assetTag = assetTag;
        this.assetType = assetType;
        this.model = model;
        this.purchaseDate = purchaseDate;
        this.status = status;
        this. currentHolder = currentHolder;
        this.createdAt = createdAt;
    }
    }
}    
   