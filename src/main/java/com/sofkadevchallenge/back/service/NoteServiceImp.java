package com.sofkadevchallenge.back.service;

import com.sofkadevchallenge.back.DTO.NoteDTO;
import com.sofkadevchallenge.back.entity.Category;
import com.sofkadevchallenge.back.entity.Note;
import com.sofkadevchallenge.back.repository.CategoryRepository;
import com.sofkadevchallenge.back.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sofkadevchallenge.back.DTO.Mapper;

import java.util.Optional;

@Service
public class NoteServiceImp implements NoteService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public NoteDTO createNote(NoteDTO noteDTO) {
        Optional<Category> category = categoryRepository.findById(noteDTO.getIdOfCategory());
        if (category.isPresent()) {
            category.get().addNote(mapper.fromNoteDtoToEntity(noteDTO));
            noteRepository.save(mapper.fromNoteDtoToEntity(noteDTO));
            categoryRepository.save(category.get());
        }
        return noteDTO;
    }

    @Override
    public NoteDTO updateNote(NoteDTO noteDTO) {
        return mapper.fromEntityToNoteDto(noteRepository.save(mapper.fromNoteDtoToEntity(noteDTO)));
    }

    @Override
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
