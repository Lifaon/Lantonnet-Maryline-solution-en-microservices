package com.medilabo.patient.controller;

import com.medilabo.patient.api.PatientApi;
import com.medilabo.patient.api.PatientDTO;
import com.medilabo.patient.model.DefaultPatient;
import com.medilabo.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PatientController implements PatientApi {

	@Autowired
	private PatientRepository repo;

	@Override
	public void create(PatientDTO patient) {
		repo.save(new DefaultPatient(patient));
	}

	@Override
	public List<PatientDTO> getAll() {
		return repo.findAll().stream()
				.map(PatientDTO::new)
				.toList();
	}

	@Override
	public PatientDTO get(Integer id) {
		return new PatientDTO(repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
	}

	@Override
	public void update(PatientDTO patient) {
		if (!repo.existsById(patient.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		repo.save(new DefaultPatient(patient));
	}

	@Override
	public void delete(Integer id) {
		if (!repo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}
		repo.deleteById(id);
	}
}
