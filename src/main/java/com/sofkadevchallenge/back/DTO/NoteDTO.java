package com.sofkadevchallenge.back.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NoteDTO {
    private Long id;
    private String message;
    private boolean done;
    private Long idOfCategory;
    private List<TagDTO> tags = new ArrayList<>();
}
