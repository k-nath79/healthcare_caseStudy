package com.healthcare_microservice_casestudy.DoctorService.Repository;

import com.healthcare_microservice_casestudy.DoctorService.Domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
