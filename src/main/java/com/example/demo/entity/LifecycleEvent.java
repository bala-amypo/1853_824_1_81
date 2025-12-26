package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lifecycle_events")
public class LifecycleEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Asset asset;

    private String eventType;
    private String eventDescription;
    private LocalDateTime eventDate;

    @ManyToOne
    private User performedBy;

    public LifecycleEvent() {}

    @PrePersist
    public void prePersist() {
        if (eventDate == null) eventDate = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }
    public void setAsset(Asset asset) { this.asset = asset; }
    public Asset getAsset() { return asset; }
    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    public String getEventDescription() { return eventDescription; }
    public void setEventDescription(String eventDescription) { this.eventDescription = eventDescription; }
    public void setPerformedBy(User performedBy) { this.performedBy = performedBy; }
}
