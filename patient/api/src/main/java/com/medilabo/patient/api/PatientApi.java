package com.medilabo.patient.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface PatientApi {

	@PostMapping("/patients")
	void create(@RequestBody PatientDTO patient);

	@GetMapping("/patients")
	List<PatientDTO> getAll();

	@GetMapping("/patients/{id}")
	PatientDTO get(@PathVariable Integer id);

	@PutMapping("/patients")
	void update(@RequestBody PatientDTO patient);

	@DeleteMapping("/patients/{id}")
	void delete(@PathVariable Integer id);
}