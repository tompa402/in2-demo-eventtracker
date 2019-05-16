package hr.in2.novak.eventtracker.controller;

import hr.in2.novak.eventtracker.model.Event;
import hr.in2.novak.eventtracker.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/event")
@Controller
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/new")
    public String showEventForm(Model model) {

        return "event/eventForm";
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/new")
    public String processEvent(Model model, Event event, Errors errors) {
        log.info("Processing event: " + event);
        if (errors.hasErrors()) {
            log.info("Event object have errors. Saving canceled. Returning object with error to user.");
            return "event/eventForm";
        }
        log.info("Event saved successfully. Event Id:" + event.getId());
        return "event/details";
    }


}
