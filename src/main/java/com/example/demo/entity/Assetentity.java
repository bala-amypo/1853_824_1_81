
package com.example.demo.repository;
import jakarta.persistence.Entity;

@Entity
public class Assetentity  {
    private Long Id
    private String assetTag;
    private String assetType;
    private String model;
    private LocalDate PurchaseData ;
    private String status;
    private User currentHolder;
    private LocalDateTime createdAt
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
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
    public LocalDate getPurchaseData() {
        return PurchaseData;
    }
    public void setPurchaseData(LocalDate purchaseData) {
        PurchaseData = purchaseData;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public User getCurrentHolder() {
        return currentHolder;
    }
    public void setCurrentHolder(User currentHolder) {
        this.currentHolder = currentHolder;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
}
}