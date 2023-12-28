package dev.domain;

import java.time.LocalDate;
import java.time.Period;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinAgeValidator implements ConstraintValidator<MinAge, LocalDate> {

    private int minAge;

    @Override
    public void initialize(MinAge minAge) {
        this.minAge = minAge.value();
    }

    @Override
    public boolean isValid(LocalDate dateOfBirth, ConstraintValidatorContext context) {
        if (dateOfBirth == null) {
            return true;
        }

        return Period.between(dateOfBirth, LocalDate.now()).getYears() >= minAge;
    }
}
