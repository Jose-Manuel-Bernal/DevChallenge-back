package com.sofkadevchallenge.back.service;

import com.sofkadevchallenge.back.DTO.CategoryDTO;
import com.sofkadevchallenge.back.entity.Category;
import com.sofkadevchallenge.back.entity.Note;
import com.sofkadevchallenge.back.repository.CategoryRepository;
import com.sofkadevchallenge.back.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MainServiceImp implements MainServices{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private CategoryDTO categoryDTO;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }


    @Override
    public void deleteCategory(Category category) {
        Category categoryToDelete = categoryRepository.findById(category.getId()).get();
        if (!categoryToDelete.getNotes().isEmpty()) {
            categoryToDelete.getNotes().forEach(note -> noteRepository.deleteById(note.getId()));
        }
        categoryRepository.deleteById(category.getId());
    }

    @Override
    public CategoryDTO getAllElements() {
        categoryDTO.setCategoryList(getCategories());
        categoryDTO.setNoteList(getNotes());
        return categoryDTO;
    }

    private List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    private List<Note> getNotes(){
        return noteRepository.findAll();
    }
}