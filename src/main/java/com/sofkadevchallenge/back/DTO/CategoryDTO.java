package com.sofkadevchallenge.back.DTO;

import com.sofkadevchallenge.back.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryDTO {

    @Autowired

    private List<Category> categoryList = new ArrayList<>();

    public void addCategory (Category category){
        categoryList.add(category);
    }
}
