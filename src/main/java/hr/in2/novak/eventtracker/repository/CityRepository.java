package hr.in2.novak.eventtracker.repository;

import hr.in2.novak.eventtracker.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
