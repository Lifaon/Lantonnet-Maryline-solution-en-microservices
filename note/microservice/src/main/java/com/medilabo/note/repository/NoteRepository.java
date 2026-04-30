package com.medilabo.note.repository;

import com.medilabo.note.model.DefaultNote;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<DefaultNote, String> {

}
