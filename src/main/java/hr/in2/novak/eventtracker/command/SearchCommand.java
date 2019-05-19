package hr.in2.novak.eventtracker.command;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchCommand {

    private String name;
    private LocalDateTime fromStartDate;
    private LocalDateTime toStartDate;
    private LocalDateTime fromEndDate;
    private LocalDateTime toEndDate;
    private String freeEntry;
    private List<Long> selectedOrg;
    private List<Long> selectedSubOrg;
    private List<Long> selectedCityTypes;
    private List<Long> selectedCities;
}
