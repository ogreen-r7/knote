package com.acme.noteservice.controllers;

import com.acme.noteservice.model.Note;
import com.acme.noteservice.repositories.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/notes")
public class NotesController {

    private final NoteRepository noteRepository;
    private final Environment environment;

    public NotesController(NoteRepository noteRepository, Environment environment) {
        this.noteRepository = noteRepository;
        this.environment = environment;
    }

    @GetMapping("/")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @PostMapping("/")
    public void saveNote(@RequestBody Note note) {
        log.info("note to save: " + note);
        Note savedNote = noteRepository.save(note);
        log.info("@@@ saved: " + savedNote);
    }

    @PutMapping("/")
    public void updateNote(@RequestBody Note note) {
        log.info("update note: " + note);
        noteRepository.save(note);
    }

    @DeleteMapping("/")
    public void deleteNote(@RequestParam String id) {
        noteRepository.deleteById(id);
    }

    @GetMapping("/test")
    public String testRoute() {
        System.out.println("env msg: " + environment.getProperty("MSG"));
        System.out.println("env mongo: " + environment.getProperty("MONGO_URL"));
        return "noteservice V0.1";
    }
}
