package hr.in2.novak.eventtracker.controller;

import hr.in2.novak.eventtracker.command.SearchCommand;
import hr.in2.novak.eventtracker.model.Event;
import hr.in2.novak.eventtracker.service.CityService;
import hr.in2.novak.eventtracker.service.EventService;
import hr.in2.novak.eventtracker.service.OrganisationUnitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RequestMapping("/event")
@Controller
public class EventController {

    private final EventService eventService;
    private final CityService cityService;
    private final OrganisationUnitService organisationUnitService;

    @Autowired
    public EventController(EventService eventService, CityService cityService, OrganisationUnitService unitService) {
        this.eventService = eventService;
        this.cityService = cityService;
        this.organisationUnitService = unitService;
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/new")
    public String showEventForm(Model model) {
        model.addAttribute("event", Event.builder().build());
        model.addAttribute("cities", cityService.findAll());
        return "event/eventForm";
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/new")
    public String processEvent(Model model, @Validated Event event, Errors errors) {
        log.info("Processing event: " + event);
        if (errors.hasErrors()) {
            log.info("Event object have errors. Saving canceled. Returning object with error to user.");
            model.addAttribute("event", event);
            model.addAttribute("cities", cityService.findAll());
            return "event/eventForm";
        }
        eventService.save(event);
        log.info("Event saved successfully. Event Id:" + event.getId());
        return "redirect:/event/" + event.getId();
    }

    @GetMapping("")
    public String getAllEvents(Model model) {
        model.addAttribute("events", eventService.findAll());
        return "event/list";
    }

    @GetMapping("/{eventId}")
    public String showEvent(@PathVariable Long eventId, Model model) {
        Optional<Event> event = eventService.findById(eventId);
        if (event.isPresent()) {
            model.addAttribute("event", event.get());
        } else {
            //TODO: 404 return not found
            model.addAttribute("event", Event.builder()
                    .name("The requested event doesn't exist.")
                    .build());
        }
        return "event/eventDetails";
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/edit/{eventId}")
    public String editEvent(@PathVariable Long eventId, Model model) {
        Optional<Event> event = eventService.findById(eventId);
        if (event.isPresent()) {
            model.addAttribute("event", event.get());
        } else {
            return "redirect:/event/new";
        }
        model.addAttribute("cities", cityService.findAll());
        return "event/eventForm";
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/edit/{eventId}")
    public String processEventUpdate(@Valid Event event, Errors errors, Model model, @PathVariable Long eventId) {
        if (errors.hasErrors()) {
            model.addAttribute("event", event);
            model.addAttribute("cities", cityService.findAll());
            return "event/eventForm";
        }
        eventService.save(event);
        return "redirect:/event/" + event.getId();
    }


    @GetMapping("/search")
    public String showEventSearchForm(Model model) {
        model.addAttribute("command", SearchCommand.builder().build());
        model.addAttribute("regions", organisationUnitService.findAllRegions());
        model.addAttribute("counties", organisationUnitService.findAllCounties());
        model.addAttribute("cityTypes", cityService.findAllCityTypes());
        model.addAttribute("cities", cityService.findAll());
        return "event/searchEventForm";
    }

    @PostMapping("/search")
    public String processSearchForm(Model model, SearchCommand command) {
        model.addAttribute("events", eventService.findByCriteria(command));
        return "event/list";
    }
}
