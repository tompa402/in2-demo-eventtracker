package hr.in2.novak.eventtracker.service;

import hr.in2.novak.eventtracker.model.Event;
import hr.in2.novak.eventtracker.repository.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void save(Event event) {
        eventRepository.save(event);
    }

    public void saveAll(List<Event> events) {
        eventRepository.saveAll(events);
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Optional<Event> findById(Long eventId){
        return eventRepository.findById(eventId);
    }
}
