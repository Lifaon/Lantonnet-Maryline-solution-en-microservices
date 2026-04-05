package com.medilabo.patient.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/patients")
public interface PatientApi {

	@PostMapping
	void create(@RequestBody PatientDTO patient);

	@GetMapping
	List<PatientDTO> getAll();

	@GetMapping("/{id}")
	PatientDTO get(@PathVariable Integer id);

	@PutMapping
	void update(@RequestBody PatientDTO patient);

	@DeleteMapping("/{id}")
	void delete(@PathVariable Integer id);
}