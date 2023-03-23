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

import com.project.security.domain.ReadingNote;
import com.project.security.domain.ReadingNoteComment;
import com.project.security.jwt.SecurityUtil;
import com.project.security.service.AccountService;
import com.project.security.service.ReadingNoteCommentService;

@RestController
@RequestMapping("/readingnotecomment")
public class ReadingNoteCommentController {

	@Autowired
	private ReadingNoteCommentService readingNoteCommentService;
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/list")
	public List<ReadingNoteComment> getAll(){
		
		return readingNoteCommentService.getReadingNoteCommentList();
	}
	
	@GetMapping("/list/{id}")
	public Optional<ReadingNoteComment> getReadingNoteCommentById(@PathVariable("id") Long id) {
		
		return readingNoteCommentService.getReadingNoteCommentListById(id);
	}
	
//	@PostMapping("/regist")
//	public ReadingNoteComment registReadingNoteComment(@RequestBody ReadingNoteComment readingNoteComment) {
//		
//		return readingNoteCommentService.registReadingNoteComment(readingNoteComment);
//	}
	
	@PostMapping("/regist/{id}")
	public void registReadingNoteComment(
			@PathVariable("id") Long id,
			@RequestBody ReadingNoteComment readingNoteComment) {
		
		readingNoteComment.setAccount(accountService.accountId(SecurityUtil.getCurrentAccountEmail()).get());
		
		readingNoteCommentService.registReadingNoteComment(id, readingNoteComment);
	}
	
	@PutMapping("/update/{id}")
	public void updateReadingNoteComment(
			@PathVariable("id") Long id,
			@RequestBody ReadingNoteComment readingNoteComment) {
		
		readingNoteCommentService.updateReadingNoteComment(readingNoteComment);
	}
	
	@DeleteMapping("/delete/{id}")
	public void removeReadingNoteComment(@PathVariable Long id) {
		
		readingNoteCommentService.removeReadingNoteComment(id);
	}
}
