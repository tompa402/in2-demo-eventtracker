package hr.in2.novak.eventtracker.service;

import hr.in2.novak.eventtracker.model.City;
import hr.in2.novak.eventtracker.model.CityType;
import hr.in2.novak.eventtracker.repository.CityRepository;
import hr.in2.novak.eventtracker.repository.CityTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CityService {

    private final CityRepository cityRepository;
    private final CityTypeRepository cityTypeRepository;

    @Autowired
    public CityService(CityRepository cityRepository, CityTypeRepository cityTypeRepository) {
        this.cityRepository = cityRepository;
        this.cityTypeRepository = cityTypeRepository;
    }

    public List<CityType> findAllCityTypes() {
        return cityTypeRepository.findAll();
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public List<City> findAllByCounty(List<Long> ids) {
        return cityRepository.findAllByOrganisationUnitIdIn(ids);
    }

    public List<City> findAllByCountiesAndCitySize(List<Long> ids, List<Long> sizeIds) {
        return cityRepository.findAllByOrOrganisationUnitIdInAndCityTypeIdIn(ids, sizeIds);
    }
}
