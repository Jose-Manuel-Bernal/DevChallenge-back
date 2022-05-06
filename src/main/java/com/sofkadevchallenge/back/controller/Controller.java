package com.sofkadevchallenge.back.controller;

import com.sofkadevchallenge.back.DTO.CategoryDTO;
import com.sofkadevchallenge.back.entity.Category;
import com.sofkadevchallenge.back.service.ServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("to-do/api")
public class Controller {

    @Autowired
    private ServiceImp service;

    @GetMapping("get/dto")
    public CategoryDTO getAllElements () {return service.getAllElements();}

    @PostMapping("save/category")
    public Category createCategory(@RequestBody Category category) {
        return service.createCategory(category);}
}
