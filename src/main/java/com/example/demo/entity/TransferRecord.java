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


   public TransferRecord(){

   }
   public TransferRecord(Long id; String asset;String fromDepartment;Struing toDepartement; String transferDate; String approvedBy;){
     this.id=id;
    this.asset=asset;
    this.fromDepartment=formDepartment;
    private Struing toDepartement;
    private String transferDate;
    private String approvedBy;
   }
}