package com.healthcare_microservice_casestudy.DoctorService.Domain;

import jakarta.persistence.*;


@Entity
@Table(name= "doctors",uniqueConstraints = {@UniqueConstraint(columnNames = "email"),@UniqueConstraint(columnNames = "phone")})
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String name;
    private String department;
    private String specialization;
    private String email;
    private String phone;
    private String activeHours;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getActiveHours() {
        return activeHours;
    }

    public void setActiveHours(String activeHours) {
        this.activeHours = activeHours;
    }
}
