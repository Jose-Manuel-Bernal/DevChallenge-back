package com.sofkadevchallenge.back.service;

import com.sofkadevchallenge.back.DTO.CategoryDTO;
import com.sofkadevchallenge.back.DTO.CategoryListDTO;
import com.sofkadevchallenge.back.entity.Category;
import com.sofkadevchallenge.back.entity.Note;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryServices {

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    void deleteCategory(Long id);

    CategoryListDTO getAllElements();
}