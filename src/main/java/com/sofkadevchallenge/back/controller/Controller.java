package com.sofkadevchallenge.back.controller;

import com.sofkadevchallenge.back.DTO.CategoryDTO;
import com.sofkadevchallenge.back.entity.Category;
import com.sofkadevchallenge.back.entity.Note;
import com.sofkadevchallenge.back.service.NoteServiceImp;
import com.sofkadevchallenge.back.service.MainServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("to-do/api")
public class Controller {

    @Autowired
    private MainServiceImp mainService;

    @Autowired
    private NoteServiceImp noteService;

    @GetMapping("get/dto")
    public CategoryDTO getAllElements () {return mainService.getAllElements();}

    @PostMapping("save/category")
    public Category createCategory(@RequestBody Category category) {
        return mainService.createCategory(category);}

    @PostMapping("save/note")
    public Note createNote(@RequestBody Note note) {
        return noteService.createNote(note);
    }

}
