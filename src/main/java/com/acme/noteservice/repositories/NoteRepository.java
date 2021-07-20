package com.acme.noteservice.repositories;

import com.acme.noteservice.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {
}
