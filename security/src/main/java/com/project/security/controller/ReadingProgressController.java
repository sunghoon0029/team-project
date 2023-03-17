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

import com.project.security.domain.ReadingProgress;
import com.project.security.service.ReadingProgressService;

@RestController
@RequestMapping("/readingprogress")
public class ReadingProgressController {

	@Autowired
	private ReadingProgressService readingProgressService;
	
	@GetMapping("/list")
	public List<ReadingProgress> getAllReadingProgress() {
		
		return readingProgressService.getReadingProgressList();
	}
	
	@GetMapping("/list/{id}")
	public Optional<ReadingProgress> getReadingProgressById(@PathVariable("id") Long id) {
		
		return readingProgressService.getReadingProgressListById(id);
	}
	
	@PostMapping("/regist")
	public ReadingProgress registReadingProgress(@RequestBody ReadingProgress readingProgress) {
		
		return readingProgressService.registReadingProgress(readingProgress);
	}
	
	@PutMapping("/update/{id}")
	public void updateReadingProgress(
			@PathVariable("id") Long id,
			@RequestBody ReadingProgress readingProgress) {
		
		readingProgressService.updateReadingProgress(readingProgress);
	}
	
	@DeleteMapping("/delete/{id}")
	public void removeReadingProgress(@PathVariable Long id) {
		
		readingProgressService.removeReadingProgress(id);
	}
	
}
