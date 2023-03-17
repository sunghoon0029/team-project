package com.project.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.security.domain.ReadingNoteComment;

public interface ReadingNoteCommentRepository extends JpaRepository<ReadingNoteComment, Long>{

}
