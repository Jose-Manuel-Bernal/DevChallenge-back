package com.sofkadevchallenge.back.DTO;

import com.sofkadevchallenge.back.entity.Category;
import com.sofkadevchallenge.back.entity.Note;
import com.sofkadevchallenge.back.entity.Tag;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class Mapper {
    public Note fromNoteDtoToEntity(NoteDTO noteDto){
        Note note = new Note();
        note.setIdOfCategory(noteDto.getIdOfCategory());
        note.setDone(noteDto.isDone());
        note.setMessage(noteDto.getMessage());
        note.setId(noteDto.getId());
        List<Tag> tags = new ArrayList<>();
        if (noteDto.getTags().size() > 0) {
            noteDto.getTags().forEach(tagDTO -> tags.add(this.fromTagDtoToEntity(tagDTO)));
        }
        return note;
    }

    public NoteDTO fromEntityToNoteDto(Note note){
        List<TagDTO> tagDTOS = new ArrayList<>();
        note.getTags().forEach(tag -> tagDTOS.add(this.fromEntityToTagDto(tag)));
        NoteDTO noteDto = new NoteDTO();
        noteDto.setIdOfCategory(note.getIdOfCategory());
        noteDto.setDone(note.isDone());
        noteDto.setMessage(note.getMessage());
        noteDto.setId(note.getId());
        return noteDto;
    }

    public Category fromCategoryDtoToEntity(CategoryDTO categoryDto){
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setTitle(categoryDto.getTitle());
        List<Note> notes = new ArrayList<>();
        if(categoryDto.getNotes().size() > 0){
            categoryDto.getNotes().forEach(noteDto -> notes.add(this.fromNoteDtoToEntity(noteDto)));
            category.setNotes(notes);
        }
        category.setTag(categoryDto.getTag());
        return category;
    }

    public CategoryDTO fromEntityToCategoryDto(Category category){
        List<NoteDTO> notes = new ArrayList<>();
        category.getNotes().forEach(note -> notes.add(this.fromEntityToNoteDto(note)));
        CategoryDTO categoryDto = new CategoryDTO();
        categoryDto.setId(category.getId());
        categoryDto.setTitle(category.getTitle());
        categoryDto.setNotes(notes);
        categoryDto.setTag(category.getTag());
        return categoryDto;
    }

    public Tag fromTagDtoToEntity(TagDTO tagDTO){
        Tag tag = new Tag();
        tag.setId(tagDTO.getId());
        tag.setTag(tagDTO.getTag());
        return tag;
    }

    public TagDTO fromEntityToTagDto(Tag tag){
        TagDTO tagDTO = new TagDTO();
        tagDTO.setId(tag.getId());
        tagDTO.setTag(tag.getTag());
        return tagDTO;
    }
}
