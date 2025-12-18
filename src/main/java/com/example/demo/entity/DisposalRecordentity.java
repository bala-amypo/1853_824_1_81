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
    private AssetEntity asset;

    @Column(nullable = false)
    private String disposalMethod;

    @Column(nullable = false)
    private LocalDate disposalDate;

    @ManyToOne
    @JoinColumn(name = "approved_by", nullable = false)
    private UserEntity approvedBy;

    private String notes;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public DisposalRecordEntity() {
    }

    public DisposalRecordEntity(
            AssetEntity asset,
            String disposalMethod,
            LocalDate disposalDate,
            UserEntity approvedBy,
            String notes
    ) {
        this.asset = asset;
        this.disposalMethod = disposalMethod;
        this.disposalDate = disposalDate;
        this.approvedBy = approvedBy;
        this.notes = notes;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (asset != null) {
            asset.setStatus("DISPOSED");
        }
    }

    // Getters and setters omitted for brevity (already correct)
}
