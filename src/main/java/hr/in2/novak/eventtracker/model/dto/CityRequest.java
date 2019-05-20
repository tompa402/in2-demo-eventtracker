package hr.in2.novak.eventtracker.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityRequest {

    private List<Long> ids;

    private List<Long> sizeIds;
}
