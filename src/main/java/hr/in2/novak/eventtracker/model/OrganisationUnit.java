package hr.in2.novak.eventtracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrganisationUnit extends BaseEntity {

    private String code;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "org_unit_type_id")
    private OrganisationUnitType organisationUnitType;
    private boolean active;
}
