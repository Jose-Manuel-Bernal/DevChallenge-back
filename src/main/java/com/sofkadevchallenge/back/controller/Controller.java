package com.sofkadevchallenge.back.controller;

import com.sofkadevchallenge.back.DTO.CategoryDTO;
import com.sofkadevchallenge.back.DTO.CategoryListDTO;
import com.sofkadevchallenge.back.DTO.NoteDTO;
import com.sofkadevchallenge.back.entity.Note;
import com.sofkadevchallenge.back.service.NoteServiceImp;
import com.sofkadevchallenge.back.service.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("to-do/api")
@CrossOrigin(origins = "http://localhost:3000/")
public class Controller {

    @Autowired
    private CategoryServiceImp categoryService;

    @Autowired
    private NoteServiceImp noteService;

    @GetMapping("get/dto")
    public CategoryListDTO getAllElements () {
        return categoryService.getAllElements();
    }

    @PostMapping("save/category")
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);}

    @PostMapping("save/note")
    public NoteDTO createNote(@RequestBody NoteDTO noteDTO) {
        return noteService.createNote(noteDTO);
    }

    @PutMapping("update/note")
    public NoteDTO updateNote(@RequestBody NoteDTO noteDTO) { return noteService.updateNote(noteDTO);}

    @DeleteMapping("delete/note/{id}")
    public void deleteNote(@PathVariable Long id) {noteService.deleteNote(id);}

    @DeleteMapping("delete/category/{id}")
    public void deleteCategory(@PathVariable Long id) {categoryService.deleteCategory(id);}
}
