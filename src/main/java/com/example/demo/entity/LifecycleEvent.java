package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
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

    @PrePersist
    public void prePersist() {
        if (eventDate == null) eventDate = LocalDateTime.now();
    }

    public LifecycleEvent() {}

    public LifecycleEvent(Long id, Asset asset, String eventType,
                          String eventDescription, LocalDateTime eventDate,
                          User performedBy) {
        this.id = id;
        this.asset = asset;
        this.eventType = eventType;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.performedBy = performedBy;
    }

    // ✅ GETTERS
    public Long getId() { return id; }
    public Asset getAsset() { return asset; }
    public User getPerformedBy() { return performedBy; }
    public LocalDateTime getEventDate() { return eventDate; }

    // ✅ SETTERS
    public void setId(Long id) { this.id = id; }
    public void setAsset(Asset asset) { this.asset = asset; }
    public void setPerformedBy(User performedBy) { this.performedBy = performedBy; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    public void setEventDescription(String eventDescription) { this.eventDescription = eventDescription; }
}
