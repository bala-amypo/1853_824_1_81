package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class DisposalRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    @Column(nullable = false)
    private String disposalMethod;

    @Column(nullable = false)
    private LocalDate disposalDate;

    @ManyToOne
    @JoinColumn(name = "approved_by", nullable = false)
    private User approvedBy;

    private String notes;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // ---------- Constructors ----------

    public DisposalRecordEntity() {
    }

    public DisposalRecordEntity(
            Asset asset,
            String disposalMethod,
            LocalDate disposalDate,
            User approvedBy,
            String notes
    ) {
        this.asset = asset;
        this.disposalMethod = disposalMethod;
        this.disposalDate = disposalDate;
        this.approvedBy = approvedBy;
        this.notes = notes;
    }

    // ---------- Lifecycle ----------

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();

        // Rule: Asset status must change to DISPOSED
        if (this.asset != null) {
            this.asset.setStatus("DISPOSED");
        }
    }

    // ---------- Getters ----------

    public Long getId() {
        return id;
    }

    public Asset getAsset() {
        return asset;
    }

    public String getDisposalMethod() {
        return disposalMethod;
    }

    public LocalDate getDisposalDate() {
        return disposalDate;
    }

    public User getApprovedBy() {
        return approvedBy;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ---------- Setters ----------

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public void setDisposalMethod(String disposalMethod) {
        this.disposalMethod = disposalMethod;
    }

    public void setDisposalDate(LocalDate disposalDate) {
        this.disposalDate = disposalDate;
    }

    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
