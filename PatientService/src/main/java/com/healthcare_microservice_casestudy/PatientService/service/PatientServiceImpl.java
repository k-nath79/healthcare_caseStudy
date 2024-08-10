package com.healthcare_microservice_casestudy.PatientService.service;

import com.healthcare_microservice_casestudy.PatientService.Domain.Patient;
import com.healthcare_microservice_casestudy.PatientService.Domain.PreExistingIllness;
import com.healthcare_microservice_casestudy.PatientService.dto.IllnessDto;
import com.healthcare_microservice_casestudy.PatientService.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient createPatient(Patient patient) {
        patientRepository.findByEmailOrPhone(patient.getEmail(),patient.getPhone()).ifPresent(
                p -> {throw new RuntimeException("Patient with Email"+ patient.getEmail()+ "and Phone"+ patient.getPhone()+ "already exists");}
        );
        return patientRepository.save(patient) ;
    }

    @Override
    public Patient updatePatient(Patient patient) {

        return null;
    }

    public Patient addIllness(long id, PreExistingIllness illness){
        Patient oldPatient = patientRepository.findById(id).orElseThrow();
        oldPatient.getPreExistingIllnesses().add(illness);
        return patientRepository.save(oldPatient);
    }

    @Override
    public Patient getPatientById(long id) {
        return null;
    }

    @Override
    public Patient getPatientByEmail(String email) {
        return null;
    }

    @Override
    public Patient getPatientByPhone(String phone) {
        return null;
    }

    public List<Patient> getAllPatients(){
        return List.copyOf(patientRepository.findAll());
    }
}
