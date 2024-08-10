package com.healthcare_microservice_casestudy.PatientService.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "Illness")
public class PreExistingIllness {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int illId;
    private String illnessName;

//    @ManyToOne
//    @JoinColumn(name = )
//    private Patient patient;
}
