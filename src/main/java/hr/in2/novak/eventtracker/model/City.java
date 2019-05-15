package hr.in2.novak.eventtracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City extends BaseEntity {

    private String code;
    private String name;
    private CityType cityType;
    private OrganisationUnit organisationUnit;
    private boolean active;
}
