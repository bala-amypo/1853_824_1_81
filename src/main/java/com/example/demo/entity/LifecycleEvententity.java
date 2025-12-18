import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "lifecycle_events")
@Data // Lombok for getters/setters
public class LifecycleEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id")
    private Asset asset;

    @NotNull(message = "Event type is required")
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @NotBlank(message = "Event description cannot be empty")
    private String eventDescription;

    private LocalDateTime eventDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User performedBy;

    // Logic: Auto-generate eventDate before saving
    @PrePersist
    protected void onCreate() {
        this.eventDate = LocalDateTime.now();
    }
}