package hr.in2.novak.eventtracker.repository;

import hr.in2.novak.eventtracker.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findAllByOrganisationUnitIdIn(List<Long> ids);

    List<City> findAllByOrOrganisationUnitIdInAndCityTypeIdIn(List<Long> ids, List<Long> sizeIds);
}
