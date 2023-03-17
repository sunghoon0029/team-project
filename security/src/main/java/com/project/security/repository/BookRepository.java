package com.project.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.security.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
