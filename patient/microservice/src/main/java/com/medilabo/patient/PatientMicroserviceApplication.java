package com.medilabo.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PatientMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientMicroserviceApplication.class, args);
	}

}
