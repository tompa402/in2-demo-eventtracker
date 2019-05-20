package hr.in2.novak.eventtracker.command;

import hr.in2.novak.eventtracker.model.YesNoEnum;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchCommand {

    private String name;

    @DateTimeFormat(pattern = "dd.MM.yyyy H:mm")
    private LocalDateTime fromStartDate;

    @DateTimeFormat(pattern = "dd.MM.yyyy H:mm")
    private LocalDateTime toStartDate;

    @DateTimeFormat(pattern = "dd.MM.yyyy H:mm")
    private LocalDateTime fromEndDate;

    @DateTimeFormat(pattern = "dd.MM.yyyy H:mm")
    private LocalDateTime toEndDate;

    private YesNoEnum freeEntry;
    private List<Long> selectedOrg;
    private List<Long> selectedSubOrg;
    private List<Long> selectedCityTypes;
    private List<Long> selectedCities;
}
