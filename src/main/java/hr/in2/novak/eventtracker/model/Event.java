package hr.in2.novak.eventtracker.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Event extends BaseEntity {

    private String name;
    private LocalDateTime start;
    private LocalDateTime end;

    @Enumerated(EnumType.STRING)
    @Column(length = 2)
    private YesNoEnum freeEntry;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    private String createdBy;
    private LocalDateTime created;
    private String modifiedBy;
    private LocalDateTime modified;

    @PrePersist
    public void generateCreated() {
        this.created = LocalDateTime.now();
    }

    @PreUpdate
    public void updateModified() {
        this.modified = LocalDateTime.now();
    }
}
