package com.medilabo.note.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface NoteApi {
	@PostMapping("/notes")
	void create(@RequestBody NoteDTO note);

	@GetMapping("/notes")
	List<NoteDTO> getAll();

	@GetMapping("/notes/patient/{id}")
	List<String> getPatientData(@PathVariable Integer id);

	@GetMapping("/notes/{id}")
	NoteDTO get(@PathVariable String id);

	@PutMapping("/notes")
	void update(@RequestBody NoteDTO note);

	@DeleteMapping("/notes/{id}")
	void delete(@PathVariable String id);
}
