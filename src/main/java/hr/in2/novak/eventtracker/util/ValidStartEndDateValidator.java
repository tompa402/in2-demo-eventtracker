package hr.in2.novak.eventtracker.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

@Slf4j
public class ValidStartEndDateValidator implements ConstraintValidator<ValidStartEndDate, Object> {
    private String startDate;
    private String endDate;

    @Override
    public void initialize(final ValidStartEndDate constraintAnnotation) {
        startDate = constraintAnnotation.startDate();
        endDate = constraintAnnotation.endDate();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        try {
            final Object firstObj = BeanUtils.getProperty(value, startDate);
            final Object secondObj = BeanUtils.getProperty(value, endDate);

            return firstObj == null && secondObj == null || firstObj != null && LocalDateTime.parse((String) firstObj).isBefore(LocalDateTime.parse((String) secondObj));
        } catch (final Exception ignore) {
            log.error(ignore.getMessage());
            // ignore
        }
        return true;
    }
}
