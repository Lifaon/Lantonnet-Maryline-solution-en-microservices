package com.medilabo.patient.repository;

import com.medilabo.patient.api.Patient;
import com.medilabo.patient.model.DefaultPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<DefaultPatient, Integer> {
}
