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
    private Struing toDepartment;
    private String transferDate;
    private String approvedBy;


   public TransferRecord(){

   }
   public TransferRecord(Long id; String asset;String fromDepartment;Struing toDepartment; String transferDate; String approvedBy){
     this.id=id;
    this.asset=asset;
    this.fromDepartment=formDepartment;
    this.toDepartment=toDepartment;
    this.transferDate=transferData;
     this.approvedBy=approvedBy;
   }
}