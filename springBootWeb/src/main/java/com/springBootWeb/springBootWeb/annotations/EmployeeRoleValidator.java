package com.springBootWeb.springBootWeb.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.Size;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation, String> {

    static final List<String> roles = List.of("USER", "ADMIN");

    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
        return roles.contains(inputRole);
    }
}
