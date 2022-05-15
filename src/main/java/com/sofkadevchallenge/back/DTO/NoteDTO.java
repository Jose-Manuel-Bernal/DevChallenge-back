package com.sofkadevchallenge.back.DTO;

import lombok.Data;

@Data
public class NoteDTO {
    private Long id;
    private String message;
    private boolean done;
    private Long idOfCategory;
}
