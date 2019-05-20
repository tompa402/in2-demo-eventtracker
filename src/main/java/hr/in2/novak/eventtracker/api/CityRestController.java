package hr.in2.novak.eventtracker.api;

import hr.in2.novak.eventtracker.model.City;
import hr.in2.novak.eventtracker.model.dto.CityRequest;
import hr.in2.novak.eventtracker.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/city", produces = "application/json")
@CrossOrigin
public class CityRestController {

    private final CityService cityService;

    @Autowired
    public CityRestController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public List<City> getCitiesByCounty(@RequestBody CityRequest cityRequest) {
        return cityService.findAllByCounty(cityRequest.getIds());
    }

    @PostMapping("/by-size-and-county")
    public List<City> getAllByCountiesAndSize(@RequestBody CityRequest cityRequest) {
        return cityService.findAllByCountiesAndCitySize(cityRequest.getIds(), cityRequest.getSizeIds());
    }
}
