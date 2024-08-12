package com.healthcare_microservice_casestudy.PatientService.repository;

import com.healthcare_microservice_casestudy.PatientService.Domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>{
    Optional<Patient> findByEmailOrPhone(String email, String phone);
    Optional<Patient> findByEmail(String Email);
    Optional<Patient> findByPhone(String phone);
}
