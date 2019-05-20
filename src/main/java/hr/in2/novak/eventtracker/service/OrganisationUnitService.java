package hr.in2.novak.eventtracker.service;

import hr.in2.novak.eventtracker.model.OrganisationUnit;
import hr.in2.novak.eventtracker.repository.OrganisationUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationUnitService {

    private final OrganisationUnitRepository organisationUnitRepository;

    @Autowired
    public OrganisationUnitService(OrganisationUnitRepository organisationUnitRepository) {
        this.organisationUnitRepository = organisationUnitRepository;
    }

    public List<OrganisationUnit> findAll() {
        return organisationUnitRepository.findAll();
    }

    public List<OrganisationUnit> findAllRegions() {
        return organisationUnitRepository.findAllByOrganisationUnitIsNull();
    }

    public List<OrganisationUnit> findAllCounties() {
        return organisationUnitRepository.findAllByOrganisationUnitIsNotNull();
    }

    public List<OrganisationUnit> findAllByParentIds(List<Long> ids) {
        return organisationUnitRepository.findAllByOrganisationUnitIdIn(ids);
    }
}
