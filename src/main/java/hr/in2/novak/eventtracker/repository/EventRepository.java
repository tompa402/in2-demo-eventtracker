package hr.in2.novak.eventtracker.repository;

import hr.in2.novak.eventtracker.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByNameContains(String name);

    List<Event> findAllByFreeEntry(String freeEntry);

    List<Event> findAllByStartBetween(LocalDateTime from, LocalDateTime to);

    List<Event> findAllByEndBetween(LocalDateTime from, LocalDateTime to);

    List<Event> findAllByCityIn(List<Long> ids);
}
