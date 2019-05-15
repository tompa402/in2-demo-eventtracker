package hr.in2.novak.eventtracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event extends BaseEntity {

    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private YesNoEnum freeEntry;
    private City city;
    private String createdBy;
    private LocalDateTime created;
    private String updatedBy;
    private LocalDateTime updated;
}
