package com.project.security.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String book_title;
	
	private String book_ISBN;
	
	private String book_author;
	
	private String book_publisher;
	
	private String book_img_url;
	
//	BookCategory(1) : Book(N) 설정
//	@ManyToOne
	@Column(name = "book_category_id")
	private Long book_category_id;
	
//	Book(1) : ReadingNote(N) 설정
	@OneToMany(mappedBy = "book_id")
	public List<ReadingNote> readingNote;
	
}
