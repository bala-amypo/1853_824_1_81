package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class  disposalRecordentity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String asset;

    
    private String disposalMethod;

    private String disposalDate;

    private String approvedBy;

    private String notes;

    private String CreatedAt ;

 



    public Long getId() {
        return id;
    }

    public String getAsset() {
        return asset;
    }

    public String getdisposalMethode() {
        return getdisposalMethode;
    }

    public String getapprovedBy() {
        return getapprovedBy;
    }

    public String getnotes() {
        return notes;
    }

    public String getcreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public void setDisposalMethod(String disposalMethod) {
        this.DisposalMethod = DisposalMethod;
    }

    public void setdisposalDate(String disposalDate) {
        this.disposalDate = disposalDate;
    }

    public void setapprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public void setnotes(String notes) {
        this.notes = notes;
    }
    public void setcreatedAt(String createdAt){
        this.createdAt = createdAt;
       

    public disposalRecordentity(Long id,String asset,String disposalMethod,String disposalDate,String approvedBy,String notes,String createdAt)
    {
        this.id = id;
        this.asset = asset;
        this.disposalMethod = disposalMethod;
        this.disposalDate = disposalDate;
        this.approvedBy = approvedBy;
        this.notes = notes;
        this.createdAt = createdAt;

    }

    public disposalRecordentity(){
    }
}
