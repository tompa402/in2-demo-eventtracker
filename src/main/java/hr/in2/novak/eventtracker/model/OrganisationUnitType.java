package hr.in2.novak.eventtracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrganisationUnitType extends BaseEntity {

    private String name;
}
