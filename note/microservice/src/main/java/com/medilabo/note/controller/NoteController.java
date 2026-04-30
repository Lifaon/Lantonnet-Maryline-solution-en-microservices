package com.medilabo.note.controller;

import com.medilabo.note.api.NoteApi;
import com.medilabo.note.api.NoteDTO;
import com.medilabo.note.model.DefaultNote;
import com.medilabo.note.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NoteController implements NoteApi {
	private final NoteRepository repo;

	@Override
	public void create(NoteDTO dto) {
		DefaultNote note = new DefaultNote(dto);
		repo.save(note);
	}

	@Override
	public List<NoteDTO> getAll() {
		return repo.findAll().stream()
				.map(NoteDTO::new)
				.toList();
	}

	@Override
	public NoteDTO get(String id) {
		return new NoteDTO(repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
	}

	@Override
	public void update(NoteDTO note) {
		if (!repo.existsById(note.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		repo.save(new DefaultNote(note));
	}

	@Override
	public void delete(String id) {
		if (!repo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}
		repo.deleteById(id);
	}
}
