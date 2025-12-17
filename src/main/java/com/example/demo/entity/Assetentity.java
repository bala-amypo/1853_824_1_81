package com.example.demo.repository;
 import jakarta.persistence.Entity;
 import jakarta.persistence.Id; 
 import jakarta.persistence.GeneratedValue; 
 import jakarta.persistence.GenerationType;
 import jakarta.persistence.ManyToOne;
 import jakarta.persistence.JoinColumn;
 import java.time.LocalDate;
 import java.time.LocalDateTime;
@Entity
@Table(
    name = "assets",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "asset_tag")
    }
)
public class AssetEntity {

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
  
    @ManyToOne
    @JoinColumn(name = "current_holder_id", nullable = true)
    private User currentHolder;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

  
    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "AVAILABLE";
        }
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
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

    public User getCurrentHolder() {
        return currentHolder;
    }

    public void setCurrentHolder(User currentHolder) {
        this.currentHolder = currentHolder;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
