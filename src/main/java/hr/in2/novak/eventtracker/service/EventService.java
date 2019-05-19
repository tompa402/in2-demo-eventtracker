package hr.in2.novak.eventtracker.service;

import hr.in2.novak.eventtracker.command.SearchCommand;
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

    public Optional<Event> findById(Long eventId) {
        return eventRepository.findById(eventId);
    }

    public List<Event> processCommand(SearchCommand command) {
        List<Event> events;
        if (command.getName() != null) {
            events = eventRepository.findAllByNameContains(command.getName());
        } else if (command.getFreeEntry() != null) {
            events = eventRepository.findAllByFreeEntry(command.getFreeEntry());
        } else if (command.getFromStartDate() != null) {
            events = eventRepository.findAllByStartBetween(command.getFromStartDate(), command.getToStartDate());
        } else if (command.getToStartDate() != null) {
            events = eventRepository.findAllByEndBetween(command.getFromEndDate(), command.getToEndDate());
        } else if (command.getSelectedOrg() != null) {
            events = eventRepository.findAll();
        } else {
            events = findAll();
        }
        return events;
    }
}
