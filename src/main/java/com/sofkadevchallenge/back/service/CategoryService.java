package com.sofkadevchallenge.back.service;

import com.sofkadevchallenge.back.entity.Category;
import com.sofkadevchallenge.back.entity.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    Category createCategory(Category category);

    Category createNote(Note note);

    void deleteNote(Note note);

    void deleteCategory(Category category);

    List<Category> getCategories();
}