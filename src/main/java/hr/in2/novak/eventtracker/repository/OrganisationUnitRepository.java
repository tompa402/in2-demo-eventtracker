package hr.in2.novak.eventtracker.repository;

import hr.in2.novak.eventtracker.model.OrganisationUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganisationUnitRepository extends JpaRepository<OrganisationUnit, Long> {

    List<OrganisationUnit> findAllByOrganisationUnitIsNull();

    List<OrganisationUnit> findAllByOrganisationUnitIsNotNull();

    List<OrganisationUnit> findAllByOrganisationUnitIdIn(List<Long> ids);

}
