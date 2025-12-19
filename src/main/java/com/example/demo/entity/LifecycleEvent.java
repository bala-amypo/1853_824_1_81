package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class LifecycleEvententity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String asset;

    
    private String eventType;

    private String eventDescription;

    private String eventDate;

    private String performedBy;

 



    public Long getId() {
        return id;
    }

    public String getAsset() {
        return asset;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }
       

    public LifecycleEvententity(Long id,String asset,String eventType,String eventDescription,String eventDate,String performedBy){
        this.id = id;
        this.asset = asset;
        this.eventType = eventType;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.performedBy = performedBy;
    }

    public LifecycleEvententity(){
    }
}
