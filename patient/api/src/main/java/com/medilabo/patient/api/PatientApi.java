package com.medilabo.patient.api;

import java.util.List;

public interface PatientApi {
	void create(Patient patient);
	List<Patient> getAll();
	Patient get(Integer id);
	void update(Patient patient);
	void delete(Integer id);
}