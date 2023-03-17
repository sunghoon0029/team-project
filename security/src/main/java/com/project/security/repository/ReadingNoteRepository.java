package com.project.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.security.domain.ReadingNote;

public interface ReadingNoteRepository extends JpaRepository<ReadingNote, Long>{

}
