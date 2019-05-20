package hr.in2.novak.eventtracker.service;

import hr.in2.novak.eventtracker.command.SearchCommand;
import hr.in2.novak.eventtracker.model.Event;
import hr.in2.novak.eventtracker.model.User;
import hr.in2.novak.eventtracker.model.YesNoEnum;
import hr.in2.novak.eventtracker.repository.EventRepository;
import hr.in2.novak.eventtracker.repository.specification.EventSpecification;
import hr.in2.novak.eventtracker.util.AuthenticationFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EventService {

    private final EventRepository eventRepository;
    private final AuthenticationFacade authenticationFacade;

    @Autowired
    public EventService(EventRepository eventRepository, AuthenticationFacade authenticationFacade) {
        this.eventRepository = eventRepository;
        this.authenticationFacade = authenticationFacade;
    }

    public void save(Event event) {
        User user = (User) authenticationFacade.getAuthentication().getPrincipal();
        if (event.getFreeEntry() == null) {
            event.setFreeEntry(YesNoEnum.NE);
        }

        if (event.getId() != null) {
            event.setModifiedBy(user.getUsername());
        }
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

    public List<Event> findByCriteria(SearchCommand command) {
        return eventRepository.findAll(EventSpecification.findByCriteria(command));
    }
}
