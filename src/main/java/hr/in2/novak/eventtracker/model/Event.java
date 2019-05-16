package hr.in2.novak.eventtracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event extends BaseEntity {

    private String name;
    private LocalDateTime start;
    private LocalDateTime end;

    @Enumerated(EnumType.STRING)
    @Column(length = 2)
    private YesNoEnum freeEntry;

    @ManyToOne
    @JoinColumn(name = "city__id")
    private City city;
    private String createdBy;
    private LocalDateTime created;
    private String updatedBy;
    private LocalDateTime updated;
}
