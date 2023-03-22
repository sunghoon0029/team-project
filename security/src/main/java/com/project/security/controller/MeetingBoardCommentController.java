//package com.project.security.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.project.security.domain.MeetingBoardComment;
//import com.project.security.service.MeetingBoardCommentService;
//
//@RestController
//@RequestMapping("meetingboardcomment")
//public class MeetingBoardCommentController {
//
//	@Autowired
//	private MeetingBoardCommentService meetingBoardCommentService;
//	
//	@GetMapping("/list")
//	public List<MeetingBoardComment> getAll() {
//		
//		return meetingBoardCommentService.getMeetingBoardList();
//	}
//	
//	@GetMapping("/list/{id}")
//	public Optional<MeetingBoardComment> getMeetingBoardCommentById(Long id) {
//		
//		return meetingBoardCommentService.getMeetingBoardListById(id);
//	}
//	
//	@PostMapping("/regist")
//	public MeetingBoardComment registMeetingBoardComment(@RequestBody MeetingBoardComment meetingBoardComment) {
//		
//		return meetingBoardCommentService.registMeetingBoardComment(meetingBoardComment);
//	}
//	
//	@PutMapping("/update/{id}")
//	public void updateMeetingBoardComment(
//			@PathVariable Long id,
//			@RequestBody MeetingBoardComment meetingBoardComment) {
//		
//		meetingBoardCommentService.updateMeetingBoardComment(meetingBoardComment);
//	}
//	
//	@DeleteMapping("/delete/{id}")
//	public void removeMeetingBoardComment(@PathVariable Long id) {
//		
//		meetingBoardCommentService.removeMeetingBoardComment(id);
//	}
//	
//}
