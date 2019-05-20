package hr.in2.novak.eventtracker.repository.specification;

import hr.in2.novak.eventtracker.command.SearchCommand;
import hr.in2.novak.eventtracker.model.Event;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventSpecification {

    public static Specification<Event> findByCriteria(final SearchCommand command) {
        return (Specification<Event>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (command.getName() != null && !command.getName().isEmpty()) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("name"), "%" + command.getName() + "%")));
            }
            if (command.getFreeEntry() != null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("freeEntry"), command.getFreeEntry())));
            }
            if (command.getFromStartDate() != null && command.getToStartDate() != null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.between(root.get("start"), command.getFromStartDate(), command.getToStartDate())));
            }
            if (command.getFromEndDate() != null && command.getToEndDate() != null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.between(root.get("start"), command.getFromEndDate(), command.getToEndDate())));
            }
            if (command.getSelectedCities() != null && !command.getSelectedCities().isEmpty()) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.in(root.get("city").get("id")).value(command.getSelectedCities())));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
