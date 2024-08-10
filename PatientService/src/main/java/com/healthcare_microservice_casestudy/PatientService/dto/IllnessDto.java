package com.healthcare_microservice_casestudy.PatientService.dto;

import jakarta.validation.constraints.NotEmpty;

public record IllnessDto(int illId,
                         @NotEmpty(message = "Value of Illness can't be empty")
                         String illnessName)
{}
