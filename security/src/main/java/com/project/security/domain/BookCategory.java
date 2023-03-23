package com.project.security.domain;

import java.util.List;

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
public class BookCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String book_category_name;
	
//	BookCategory(1) : Book(N) 설정
	@OneToMany(mappedBy = "book_category_id")
	public List<Book> book;
	
////	BookCategory(1) : ReadingNote(N) 설정
//	@OneToMany(mappedBy = "book_category_id")
//	public List<ReadingNote> readingNote;
	
}
