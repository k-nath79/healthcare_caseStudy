package com.healthcare_microservice_casestudy.DoctorService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
//Verifies the transactions done by AuditEntityListenerClass
public class JPAConfiguration {

}
