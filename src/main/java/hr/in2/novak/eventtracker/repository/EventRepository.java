package hr.in2.novak.eventtracker.repository;

import hr.in2.novak.eventtracker.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {

    List<Event> findByEndLessThanEqual(LocalDateTime end);
}
