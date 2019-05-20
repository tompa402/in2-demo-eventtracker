package hr.in2.novak.eventtracker.api;

import hr.in2.novak.eventtracker.model.OrganisationUnit;
import hr.in2.novak.eventtracker.model.dto.OrganisationUnitRequest;
import hr.in2.novak.eventtracker.service.OrganisationUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/organisation-unit", produces="application/json")
@CrossOrigin
public class OrganisationUnitRestController {

    private final OrganisationUnitService organisationUnitService;

    @Autowired
    public OrganisationUnitRestController(OrganisationUnitService organisationUnitService) {
        this.organisationUnitService = organisationUnitService;
    }

    @PostMapping
    public List<OrganisationUnit> findAllByParentId(@RequestBody OrganisationUnitRequest orgUnitDto){
        return organisationUnitService.findAllByParentIds(orgUnitDto.getIds());
    }
}
