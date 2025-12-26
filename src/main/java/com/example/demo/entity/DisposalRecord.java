package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
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
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
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

    // ✅ REQUIRED GETTERS
    public Long getId() { return id; }
    public Asset getAsset() { return asset; }
    public String getDisposalMethod() { return disposalMethod; }
    public LocalDate getDisposalDate() { return disposalDate; }
    public User getApprovedBy() { return approvedBy; }
    public String getNotes() { return notes; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // setters
    public void setId(Long id) { this.id = id; }
    public void setDisposalMethod(String disposalMethod) { this.disposalMethod = disposalMethod; }
    public void setDisposalDate(LocalDate disposalDate) { this.disposalDate = disposalDate; }
    public void setApprovedBy(User approvedBy) { this.approvedBy = approvedBy; }
    public void setNotes(String notes) { this.notes = notes; }
}
