package com.sofkadevchallenge.back.service;

import com.sofkadevchallenge.back.entity.Category;
import com.sofkadevchallenge.back.entity.Note;
import com.sofkadevchallenge.back.repository.CategoryRepository;
import com.sofkadevchallenge.back.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceImp implements MainServices{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category createNote(Note note) {
        Category category = categoryRepository.findById(note.getIdOfCategory()).get();
        category.addNote(note);
        noteRepository.save(note);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteNote(Note note) {
        noteRepository.deleteById(note.getId());
    }

    @Override
    public void deleteCategory(Category category) {
        Category categoryToDelete = categoryRepository.findById(category.getId()).get();
        if (categoryToDelete.getNotes().size() >= 0) {
            categoryToDelete.getNotes().forEach(note -> noteRepository.deleteById(note.getId()));
        }
        categoryRepository.deleteById(category.getId());
    }

    @Override
    public List<Category> getCategories() {

        return null;
    }
}