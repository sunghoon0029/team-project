package com.project.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.security.domain.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long>{

}
