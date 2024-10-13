package com.springBootWeb.springBootWeb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springBootWeb.springBootWeb.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDTO {
    private Long id;
    @NotBlank(message = "Name field can't be empty")
    @Size(min = 4, max = 20, message = "Number of characters [4, 20]")
    private String name;

    @Email(message = "Provide valid email")
    private String email;

    @NotNull
//    @Pattern(regexp = "^(USER|ADMIN)$", message = "Role can be only USER / ADMIN")
    @EmployeeRoleValidation
    private String role;

    @Max(value = 125, message = "Age can't be greater than 125")
    @Min(value = 18)
    @Positive
    private Integer age;

    @Past
    private LocalDate dateOfJoining;

//    need to pass "isActive" in JSON
    @JsonProperty("isActive")
    Boolean isActive;
}
