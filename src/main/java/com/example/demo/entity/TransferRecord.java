package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

import lombok.Data;

@Entity
@Table(name = "transfer_records")
@Data
public class TransferRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String asset;

    @Column(name = "from_department", nullable = false)
    private String fromDepartment;

    @Column(name = "to_department", nullable = false)
    private String toDepartment;

    @Column(name = "transfer_date", nullable = false)
    private LocalDate transferDate;

    @Column(name = "approved_by", nullable = false)
    private String approvedBy;

    // No-arg constructor (required by JPA)
    public TransferRecord() {
    }

    // All-args constructor
    public TransferRecord(
            Long id,
            String asset,
            String fromDepartment,
            String toDepartment,
            LocalDate transferDate,
            String approvedBy
    ) {
        this.id = id;
        this.asset = asset;
        this.fromDepartment = fromDepartment;
        this.toDepartment = toDepartment;
        this.transferDate = transferDate;
        this.approvedBy = approvedBy;
    }
}
