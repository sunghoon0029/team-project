//package com.project.security.controller;
//
//import java.util.List;
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
//import com.project.security.domain.MeetingBoard;
//import com.project.security.service.MeetingBoardService;
//
//@RestController
//@RequestMapping("meetingboard")
//public class MeetingBoardController {
//
//	@Autowired
//	private MeetingBoardService meetingBoardService;
//	
//	@GetMapping("/list")
//	public List<MeetingBoard> getAll() {
//		
//		return meetingBoardService.getMeetingBoardList();
//	}
//	
//	@PostMapping("/regist")
//	public MeetingBoard registMeetingBoard(@RequestBody MeetingBoard meetingBoard) {
//
//		return meetingBoardService.registMeetingBoard(meetingBoard);
//	}
//	
//	@PutMapping("/update/{id}")
//	public void updateMeetingBoard(
//			@PathVariable("id") Long id,
//			@RequestBody MeetingBoard meetingBoard) {
//		
//		meetingBoardService.updateMeetingBoard(meetingBoard);
//	}
//	
//	@DeleteMapping("/delete/{id}")
//	public void removeMeetingBoard(@PathVariable Long id) {
//		
//		meetingBoardService.removeMeetingBoard(id);
//	}
//	
//}
