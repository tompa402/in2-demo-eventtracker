package hr.in2.novak.eventtracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganisationUnit extends BaseEntity {

    private String code;
    private String name;
    private String description;
    private OrganisationUnitType organisationUnitType;
    private boolean active;
}
