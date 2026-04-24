package com.medilabo.patient.config;

import com.medilabo.patient.api.Gender;
import com.medilabo.patient.model.DefaultPatient;
import com.medilabo.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

	private final PatientRepository patientRepository;

	@Override
	public void run(ApplicationArguments args) {
		// Only init if empty
		if (patientRepository.count() == 0) {
			patientRepository.saveAll(List.of(
				new DefaultPatient("TestNone", "Test", LocalDate.of(1966, 12, 31), Gender.F, "1 Brookside St", "100-222-3333"),
				new DefaultPatient("TestBorderline", "Test", LocalDate.of(1945,  6, 24), Gender.M, "2 High St", "200-333-4444"),
				new DefaultPatient("TestInDanger", "Test", LocalDate.of(2004,  6, 18), Gender.M, "3 Club Road", "300-444-5555"),
				new DefaultPatient("TestEarlyOnset", "Test", LocalDate.of(2002,  6, 28), Gender.F, "4 Valley Dr", "400-555-6666")
			));
		}
	}
}