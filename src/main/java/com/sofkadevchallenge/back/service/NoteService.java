package com.sofkadevchallenge.back.service;

import com.sofkadevchallenge.back.DTO.NoteDTO;
import com.sofkadevchallenge.back.entity.Note;
import org.springframework.stereotype.Service;

@Service
public interface NoteService {

    NoteDTO createNote(NoteDTO note);

    NoteDTO updateNote(NoteDTO note);

    void deleteNote(Long id);
}
