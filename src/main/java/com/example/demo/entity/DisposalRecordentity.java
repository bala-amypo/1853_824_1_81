package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class DisposalRecordentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // One-to-One with Asset
    @OneToOne
    @JoinColumn(name = "asset_id", nullable = false)
    private Assetentity asset;

    // Disposal method (RECYCLED / SOLD / SCRAPPED / RETURNED)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DisposalMethod disposalMethod;

    @Column(nullable = false)
    private LocalDate disposalDate;

    // Many-to-One with User
    @ManyToOne
    @JoinColumn(name = "approved_by", nullable = false)
    private Userentity approvedBy;

    private String notes;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // ---------- Constructors ----------

    public DisposalRecordentity() {
    }

    public DisposalRecordentity(
            Assetentity asset,
            DisposalMethod disposalMethod,
            LocalDate disposalDate,
            Userentity approvedBy,
            String notes
    ) {
        this.asset = asset;
        this.disposalMethod = disposalMethod;
        this.disposalDate = disposalDate;
        this.approvedBy = approvedBy;
        this.notes = notes;
    }

    // ---------- Business Rules ----------

    @PrePersist
    public void prePersist() {

        // auto-generate createdAt
        this.createdAt = LocalDateTime.now();

        // disposalDate cannot be future
        if (disposalDate.isAfter(LocalDate.now())) {
            throw new IllegalStateException("Disposal date cannot be in the future");
        }

        // approvedBy must be ADMIN
        if (approvedBy == null || !"ADMIN".equalsIgnoreCase(approvedBy.getRole())) {
            throw new IllegalStateException("Disposal must be approved by ADMIN");
        }

        // auto-update asset status
        asset.setStatus("DISPOSED");
    }

    // ---------- Getters ----------

    public Long getId() {
        return id;
    }

    public Assetentity getAsset() {
        return asset;
    }

    public DisposalMethod getDisposalMethod() {
        return disposalMethod;
    }

    public LocalDate getDisposalDate() {
        return disposalDate;
    }

    public Userentity getApprovedBy() {
        return approvedBy;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ---------- Setters ----------

    public void setAsset(Assetentity asset) {
        this.asset = asset;
    }

    public void setDisposalMethod(DisposalMethod disposalMethod) {
        this.disposalMethod = disposalMethod;
    }

    public void setDisposalDate(LocalDate disposalDate) {
        this.disposalDate = disposalDate;
    }

    public void setApprovedBy(Userentity approvedBy) {
        this.approvedBy = approvedBy;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
