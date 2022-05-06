package com.sofkadevchallenge.back.service;

import com.sofkadevchallenge.back.entity.Note;
import org.springframework.stereotype.Service;

@Service
public interface NoteService {

    Note createNote(Note note);

    Note updateNote(Note note);

    void deleteNote(Note note);
}
