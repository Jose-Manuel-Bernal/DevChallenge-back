package com.sofkadevchallenge.back.repository;

import com.sofkadevchallenge.back.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
