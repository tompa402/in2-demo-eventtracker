package hr.in2.novak.eventtracker.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Event extends BaseEntity {

    @NotEmpty(message = "Please enter name of event")
    @Size(min = 3, max = 128, message = "Name of event can have between 4 and 128 characters")
    private String name;

    @NotNull(message = "Please enter start date of event")
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    @FutureOrPresent(message = "Start date can't be in past")
    private LocalDateTime start;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    @FutureOrPresent(message = "End date can't be in past")
    private LocalDateTime end;

    @Enumerated(EnumType.STRING)
    @Column(length = 2)
    private YesNoEnum freeEntry;

    @NotNull(message = "Please choose city where event will be held")
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
