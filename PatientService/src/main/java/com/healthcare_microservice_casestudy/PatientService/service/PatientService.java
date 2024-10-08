package com.healthcare_microservice_casestudy.PatientService.service;

import com.healthcare_microservice_casestudy.PatientService.Domain.Patient;
import com.healthcare_microservice_casestudy.PatientService.Domain.PreExistingIllness;


import java.util.List;

public interface PatientService {
    Patient createPatient(Patient patient);
    Patient updatePatient(long Id,Patient patient);
    Patient getPatientById(long id);
    Patient getPatientByEmail(String email);
    Patient getPatientByPhone(String phone);
    List<Patient> getAllPatients();
    Patient addIllness(long id, PreExistingIllness illness);

}
