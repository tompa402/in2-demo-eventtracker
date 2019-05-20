package hr.in2.novak.eventtracker.repository;

import hr.in2.novak.eventtracker.model.CityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityTypeRepository extends JpaRepository<CityType, Long> {
}
