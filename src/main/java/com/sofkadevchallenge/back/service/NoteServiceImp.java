package com.sofkadevchallenge.back.service;

import com.sofkadevchallenge.back.entity.Category;
import com.sofkadevchallenge.back.entity.Note;
import com.sofkadevchallenge.back.repository.CategoryRepository;
import com.sofkadevchallenge.back.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoteServiceImp implements NoteService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note createNote(Note note) {
        Optional<Category> category = categoryRepository.findById(note.getIdOfCategory());
        if (category.isPresent()) {
            category.get().addNote(note);
            noteRepository.save(note);
            categoryRepository.save(category.get());
        }
        return note;
    }

    @Override
    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
