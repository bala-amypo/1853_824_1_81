package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

@Entity
public class LifecycleEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    private String eventType;

    private String eventDescription;

    private LocalDateTime eventDate;

    @ManyToOne
    @JoinColumn(name = "performed_by")
    private User performedBy;

    public LifecycleEvent() {
    }

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

    @PrePersist
    public void prePersist() {
        if (eventDate == null) {
            eventDate = LocalDateTime.now();
        }
    }

    /* ===== GETTERS ===== */

    public Long getId() {
        return id;
    }

    public Asset getAsset() {
        return asset;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public User getPerformedBy() {
        return performedBy;
    }

    /* ===== SETTERS (TESTS REQUIRE THESE) ===== */

    public void setId(Long id) {
        this.id = id;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setPerformedBy(User performedBy) {
        this.performedBy = performedBy;
    }
}
