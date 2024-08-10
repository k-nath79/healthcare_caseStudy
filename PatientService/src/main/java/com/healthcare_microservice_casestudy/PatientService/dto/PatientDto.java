package com.healthcare_microservice_casestudy.PatientService.dto;

import com.healthcare_microservice_casestudy.PatientService.Domain.PreExistingIllness;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;

public record PatientDto(long id,

                         @NotEmpty(message = "Name is required")
                         @Length(min = 3, max = 50, message = "Not valid name length(3 to 50)")
                         String fullName,

                         @NotEmpty(message = "Email is required")
                         @Email(message = "Invalid Email")
                         String email,

                         @NotEmpty(message = "Phone is required")
                         @Pattern(regexp = "((\\+*)((0[ -]*)*|((91 )*))((\\d{12})+|(\\d{10})+))|\\d{5}([- ]*)\\d{6}", message = "Phone is invalid")
                         String phone,

                         @NotEmpty(message = "Address is required")
                         String address,

                         @Past(message = "Date of birth must be in past")
                         LocalDate dob,

                         List<PreExistingIllness> preExistingIllnesses)
{
}
