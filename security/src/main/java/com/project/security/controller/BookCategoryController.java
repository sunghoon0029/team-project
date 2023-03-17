package com.project.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.security.domain.BookCategory;
import com.project.security.service.BookCategoryService;

@RestController
@RequestMapping("/bookcategory")
public class BookCategoryController {
	
	@Autowired
	private BookCategoryService bookCategoryService;
	
	@GetMapping("/list")
	public List<BookCategory> getAll() {
		
		return bookCategoryService.getBookCategoryList();
	}
	
	@GetMapping("/list/{id}")
	public Optional<BookCategory> getBookCategoryById(@PathVariable("id") Long id) {
		
		return bookCategoryService.getBookCategoryListById(id);
	}
	
	@PostMapping("/regist")
	public BookCategory registBookCategory(@RequestBody BookCategory bookCategory) {
		
		System.out.println(bookCategory);
		
		return bookCategoryService.registBookCategory(bookCategory);
	}
	
	@PutMapping("/update/{id}")
	public void updateBookCategory(
			@PathVariable("id") Long id,
			@RequestBody BookCategory bookCategory) {
		
		bookCategoryService.updateBookCategory(bookCategory);
	}
	
	@DeleteMapping("/delete/{id}")
	public void removeBookCategory(@PathVariable Long id) {
		
		bookCategoryService.removeBookCategory(id);
	}
	
}
