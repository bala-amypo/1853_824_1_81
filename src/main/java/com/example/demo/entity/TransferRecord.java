package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@Data
public  class TransferRecord{
    private Long id;
    private String asset;
    private String fromDepartment;
    private Struing toDepartement;
    private String transferDate;
    private String approvedBy;
    
}