package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class DisposalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Asset asset;

    private String disposalMethod;
    private LocalDate disposalDate;

    @ManyToOne
    private User approvedBy;

    private String notes;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (createdAt == null) createdAt = LocalDateTime.now();
    }

    public DisposalRecord() {}

    public DisposalRecord(Long id, Asset asset, String disposalMethod,
                          LocalDate disposalDate, User approvedBy,
                          String notes, LocalDateTime createdAt) {
        this.id = id;
        this.asset = asset;
        this.disposalMethod = disposalMethod;
        this.disposalDate = disposalDate;
        this.approvedBy = approvedBy;
        this.notes = notes;
        this.createdAt = createdAt;
    }

    // ✅ GETTERS
    public Long getId() { return id; }
    public User getApprovedBy() { return approvedBy; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // ✅ SETTERS
    public void setId(Long id) { this.id = id; }
    public void setAsset(Asset asset) { this.asset = asset; }
    public void setApprovedBy(User approvedBy) { this.approvedBy = approvedBy; }
    public void setDisposalMethod(String disposalMethod) { this.disposalMethod = disposalMethod; }
    public void setDisposalDate(LocalDate disposalDate) { this.disposalDate = disposalDate; }
}
