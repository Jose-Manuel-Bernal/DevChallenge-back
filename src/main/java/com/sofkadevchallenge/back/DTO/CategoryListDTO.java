package com.sofkadevchallenge.back.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class CategoryListDTO {
    private List<CategoryDTO> categoryList;
}
