package com.sofkadevchallenge.back.DTO;

import com.sofkadevchallenge.back.entity.Category;
import com.sofkadevchallenge.back.entity.Note;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class CategoryDTO {
    private Long id;
    private String title;
    private String tag;
    private List<NoteDTO> notes = new ArrayList<>();
}
