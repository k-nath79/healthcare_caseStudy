package com.healthcare_microservice_casestudy.PatientService.Domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "patients",uniqueConstraints = {@UniqueConstraint(columnNames = "email"),@UniqueConstraint(columnNames = "phone")})

public class Patient {

    @Id
    @TableGenerator(
            name = "patient_id_generator",
            initialValue = 100
    )
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "patient_id_generator")
    private long id;
    private String FullName;
    private String phone;
    private String address;
    private String email;
    private LocalDate dob;

    @CreatedDate
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdOn;

    @LastModifiedDate
    private LocalDateTime updatedOn;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "illness_table")
    private List<PreExistingIllness> preExistingIllnesses;
}

