package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LifecycleEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String asset;
    private String eventType;
    private String eventDescription;
    private String eventDate;
    private String performedBy;


    public LifecycleEventEntity(){

    }

    public LifecycleEventEntity(Long id,String asset,String eventType,String eventDescription,String eventDate,String performedBy){
        this.id=id;
        this.asset=asset;
        this.eventType=eventType;
        this.eventDescription=
    }
  
    
    


}
