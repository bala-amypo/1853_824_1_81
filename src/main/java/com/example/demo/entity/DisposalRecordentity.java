package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class  DisposalRecordentity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String asset;

    
    private String DisposalMethod;

    private String DisposalDate;

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

    public void setDisposalMethod(String DisposalMethod) {
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


    }

    public DisposalRecordentity(){
    }
}
