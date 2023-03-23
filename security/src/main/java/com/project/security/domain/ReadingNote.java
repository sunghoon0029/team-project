package com.project.security.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class ReadingNote extends Base{

	@Id @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String reading_note_title;
	
	private String reading_note_hashtag;
	
	private String reading_note_content;
	
	private int reading_note_hit;
	
	private int reading_note_like;
	
	private int reading_note_bookmark;
	
	private String reading_note_file_url;
	
	private int reading_note_open;
	
	
	// Account(1) : ReadingNote(N) 설정
	@ManyToOne
	@JoinColumn(name="account_id")
	@JsonIgnoreProperties({"readingNote"})
	private Account account;
	
	// Book(1) : ReadingNote(N) 설정
//	@ManyToOne
	@Column(name = "book_id")
	private Long book_id;
	
	// ReadingNote(1) : ReadingNoteComment(N) 설정
	@OneToMany(mappedBy="readingNote", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"readingNote"})
	@Builder.Default
	private List<ReadingNoteComment> readingNoteComment = new ArrayList<>();
	
}
