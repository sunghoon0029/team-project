package com.project.security.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReadingNoteComment extends Base{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String content;
	
	private int reading_note_comment_like;
	

	// Account(1) : ReadingNoteComment(N) 설정
	@ManyToOne
	@JoinColumn(name="account_id")
	@JsonIgnoreProperties({"readingNoteComment"})
	private Account account;
	
	// ReadingNote(1) : ReadingNoteComment(N) 설정
	@ManyToOne
	@JoinColumn(name="reading_note_id")
	@JsonIgnoreProperties({"readingNoteComment"})
	private ReadingNote readingNote;
	
}
