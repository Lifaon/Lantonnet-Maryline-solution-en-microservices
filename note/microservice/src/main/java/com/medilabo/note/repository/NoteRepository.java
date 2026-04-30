package com.medilabo.note.repository;

import com.medilabo.note.model.DefaultNote;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Arrays;
import java.util.List;

public interface NoteRepository extends MongoRepository<DefaultNote, String> {

	List<DefaultNote> findAllByPatientId(Integer id);
}
