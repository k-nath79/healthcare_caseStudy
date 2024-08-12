package com.healthcare_microservice_casestudy.PatientService.service;

import com.healthcare_microservice_casestudy.PatientService.Domain.Patient;
import com.healthcare_microservice_casestudy.PatientService.Domain.PreExistingIllness;

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
    public Patient updatePatient(long Id,Patient patient) {
        Patient oldPatient = patientRepository.findById(Id).orElseThrow(()-> new RuntimeException("Patient does not exist"));
        oldPatient.setFullName(patient.getFullName());
        oldPatient.setDob(patient.getDob());
        oldPatient.setAddress(patient.getAddress());
        oldPatient.setPhone(patient.getPhone());
        oldPatient.setPreExistingIllnesses(patient.getPreExistingIllnesses());
        return patientRepository.save(oldPatient);
    }

    public Patient addIllness(long id, PreExistingIllness illness){
        Patient oldPatient = patientRepository.findById(id).orElseThrow();
        oldPatient.getPreExistingIllnesses().add(illness);
        return patientRepository.save(oldPatient);
    }

    @Override
    public Patient getPatientById(long id) {
        return patientRepository.findById(id).orElseThrow(()-> new RuntimeException("Patient with specified ID not found"));
    }

    @Override
    public Patient getPatientByEmail(String email) {
        return patientRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("Patient with specified email is not found"));
    }

    @Override
    public Patient getPatientByPhone(String phone) {
        return patientRepository.findByPhone(phone).orElseThrow(()-> new RuntimeException("Patient with specified email is not found"));
    }

    public List<Patient> getAllPatients(){
        return List.copyOf(patientRepository.findAll());
    }
}
