package com.healthcare_microservice_casestudy.PatientService.controller;

import com.healthcare_microservice_casestudy.PatientService.Domain.Patient;
import com.healthcare_microservice_casestudy.PatientService.Domain.PreExistingIllness;
import com.healthcare_microservice_casestudy.PatientService.dto.IllnessDto;
import com.healthcare_microservice_casestudy.PatientService.dto.PatientDto;
import com.healthcare_microservice_casestudy.PatientService.service.PatientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {
    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@Valid @RequestBody PatientDto patientDto){
        Patient patient = toEntity(patientDto);
        patient= patientService.createPatient(patient);
        patientDto = toDto(patient);

        return ResponseEntity.status(HttpStatus.CREATED).body(patientDto);
    }
    @PostMapping("/u/{id}")
    public ResponseEntity<Patient> addIllness(@PathVariable long id,@Valid @RequestBody IllnessDto illnessDto){
        PreExistingIllness illness = new PreExistingIllness();
        illness.setIllnessName(illnessDto.illnessName());
        Patient patient = patientService.addIllness(id,illness);
        return ResponseEntity.status(HttpStatus.CREATED).body(patient);
    }

    @GetMapping("/get")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }


    private PatientDto toDto(Patient patient){
        return new PatientDto(patient.getId(),
                patient.getFullName(),
                patient.getEmail(),
                patient.getPhone(),
                patient.getAddress(),
                patient.getDob(),
                patient.getPreExistingIllnesses());
    };


    public Patient toEntity(PatientDto patientDto){
        Patient patient = new Patient();
        patient.setFullName(patientDto.fullName());
        patient.setDob(patientDto.dob());
        patient.setId(patientDto.id());
        patient.setPhone(patientDto.phone());
        patient.setEmail(patientDto.email());
        patient.setPreExistingIllnesses(patientDto.preExistingIllnesses());

        return patient;
    }
}
