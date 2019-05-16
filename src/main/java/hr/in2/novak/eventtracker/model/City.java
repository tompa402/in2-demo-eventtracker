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
public class City extends BaseEntity {

    private String code;
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_type_id")
    private CityType cityType;

    @ManyToOne
    @JoinColumn(name = "org_unit_id")
    private OrganisationUnit organisationUnit;
    private boolean active;
}
