package com.healthcare_microservice_casestudy.DoctorService.DAO;

import jakarta.validation.constraints.NotEmpty;

public record DoctorDao(long id,
                        @NotEmpty(message = "Name Required")
         String name,
                        @NotEmpty(message = "Department Required")
                        String department,
                        @NotEmpty(message = "Specialization Required")
                        String specialization,
                        @NotEmpty(message = "Email Required")
                        String email,
                        @NotEmpty(message = "Phone Required")
                        String phone,
                        @NotEmpty(message = "Mention the Hours Active")
                        String activeHours) {
}
