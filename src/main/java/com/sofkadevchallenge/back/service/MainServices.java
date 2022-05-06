package com.sofkadevchallenge.back.service;

import com.sofkadevchallenge.back.DTO.CategoryDTO;
import com.sofkadevchallenge.back.entity.Category;
import com.sofkadevchallenge.back.entity.Note;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MainServices {

    Category createCategory(Category category);

    Note createNote(Note note);

    void deleteNote(Note note);

    void deleteCategory(Category category);

    CategoryDTO getAllElements();
}