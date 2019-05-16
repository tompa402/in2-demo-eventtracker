package hr.in2.novak.eventtracker.bootstrap;

import hr.in2.novak.eventtracker.model.City;
import hr.in2.novak.eventtracker.model.Event;
import hr.in2.novak.eventtracker.model.YesNoEnum;
import hr.in2.novak.eventtracker.service.CityService;
import hr.in2.novak.eventtracker.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Component
@Profile("dev")
public class DataLoader implements CommandLineRunner {

    private final EventService eventService;
    private final CityService cityService;

    @Autowired
    public DataLoader(EventService eventService, CityService cityService) {
        this.eventService = eventService;
        this.cityService = cityService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("loading initial event data...");

        int count = eventService.findAll().size();

        if (count == 0) {
            loadData();
        }
        log.info("initial data loaded...");
    }

    private void loadData() {
        List<String> randomEventNames = loadRandomEventNames();
        List<City> cities = cityService.findAll();
        List<Event> events = new ArrayList<>();

        for (int i = 0; i <= 100; i++) {
            events.add(Event.builder()
                    .name(randomEventNames != null ? randomEventNames.get(i) : "randomName" + i)
                    .start(LocalDateTime.now().plusDays(i))
                    .end(LocalDateTime.now().plusDays(i))
                    .freeEntry(YesNoEnum.values()[new Random().nextInt(YesNoEnum.values().length)])
                    .city(cities.get(new Random().nextInt(cities.size())))
                    .createdBy("default")
                    .build());
        }
        eventService.saveAll(events);
    }

    private List<String> loadRandomEventNames() {
        try (Stream<String> lines = Files.lines(ResourceUtils
                .getFile("classpath:files/EventRandomNames.txt").toPath())) {
            return lines.collect(Collectors.toList());
        } catch (Exception ex) {
            log.error("Error occurred while accessing resource.");
        }
        return null;
    }
}
