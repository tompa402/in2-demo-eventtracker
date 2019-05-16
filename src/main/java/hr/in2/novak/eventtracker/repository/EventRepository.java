package hr.in2.novak.eventtracker.repository;

import hr.in2.novak.eventtracker.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
