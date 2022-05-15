package com.sofkadevchallenge.back.service;

import com.sofkadevchallenge.back.DTO.CategoryDTO;
import com.sofkadevchallenge.back.DTO.CategoryListDTO;
import com.sofkadevchallenge.back.entity.Category;
import com.sofkadevchallenge.back.repository.CategoryRepository;
import com.sofkadevchallenge.back.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sofkadevchallenge.back.DTO.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryServices {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NoteRepository noteRepository;

//    @Autowired
//    private CategoryDTO categoryDTO;

    @Autowired
    private Mapper mapper;

    @Autowired
    private CategoryListDTO categoryListDTO;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return mapper.fromEntityToCategoryDto(categoryRepository.save(mapper.fromCategoryDtoToEntity(categoryDTO)));
    }


    @Override
    public void deleteCategory(Long id) {
        Optional<Category> categoryToDelete = categoryRepository.findById(id);
        if (!categoryToDelete.get().getNotes().isEmpty()) {
            categoryToDelete.get().getNotes().forEach(note -> noteRepository.deleteById(note.getId()));

        }
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryListDTO getAllElements() {
        categoryListDTO.setCategoryList(getCategoriesDTOs());
        return categoryListDTO;
    }

    private List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    private List<CategoryDTO> getCategoriesDTOs(){
        List<CategoryDTO> categoryDtos = new ArrayList<>();
        categoryRepository.findAll().forEach(category -> categoryDtos.add(mapper.fromEntityToCategoryDto(category)));
        return categoryDtos;
    }
}