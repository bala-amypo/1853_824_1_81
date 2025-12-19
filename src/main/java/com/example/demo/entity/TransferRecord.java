package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "transfer_records")
public class TransferRecordentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-One with Asset
    @ManyToOne
    @JoinColumn(name = "asset_id", nullable = false)
    private Assetentity asset;

    @Column(name = "from_department", nullable = false)
    private String fromDepartment;

    @Column(name = "to_department", nullable = false)
    private String toDepartment;

    @Column(name = "transfer_date", nullable = false)
    private LocalDate transferDate;

    // Many-to-One with User (ADMIN)
    @ManyToOne
    @JoinColumn(name = "approved_by", nullable = false)
    private Userentity approvedBy;

    // -------- Constructors --------

    public TransferRecordentity() {
    }

    public TransferRecordentity(
            Assetentity asset,
            String fromDepartment,
            String toDepartment,
            LocalDate transferDate,
            Userentity approvedBy
    ) {
        this.asset = asset;
        this.fromDepartment = fromDepartment;
        this.toDepartment = toDepartment;
        this.transferDate = transferDate;
        this.approvedBy = approvedBy;
    }

    // -------- Business Rules & Validation --------

    @PrePersist
    public void validateTransfer() {

        // fromDepartment must differ from toDepartment
        if (fromDepartment != null && fromDepartment.equalsIgnoreCase(toDepartment)) {
            throw new IllegalStateException(
                    "From department and To department must be different"
            );
        }

        // transferDate cannot be future
        if (transferDate.isAfter(LocalDate.now())) {
            throw new ValidationException(
                    "Transfer date cannot be in the future"
            );
        }

        // approvedBy must be ADMIN
        if (approvedBy == null || !"ADMIN".equalsIgnoreCase(approvedBy.getRole())) {
            throw new IllegalStateException(
                    "Transfer must be approved by ADMIN"
            );
        }
    }


}
