//package com.project.security.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.project.security.domain.MeetingBoardComment;
//import com.project.security.repository.MeetingBoardCommentRepository;
//
//@Service
//public class MeetingBoardCommentService {
//
//	@Autowired
//	private MeetingBoardCommentRepository meetingBoardCommentRepository;
//	
//	// 조회
//	public List<MeetingBoardComment> getMeetingBoardList() {
//		
//		return meetingBoardCommentRepository.findAll();
//	}
//	
//	// 개별 조회
//	public Optional<MeetingBoardComment> getMeetingBoardListById(Long id) {
//		
//		return meetingBoardCommentRepository.findById(id);
//	}
//	
//	// 작성
//	public MeetingBoardComment registMeetingBoardComment(MeetingBoardComment meetingBoardComment) {
//		
//		return meetingBoardCommentRepository.save(meetingBoardComment);
//	}
//	
//	// 수정
//	public MeetingBoardComment updateMeetingBoardComment(MeetingBoardComment meetingBoardComment) {
//		
//		return meetingBoardCommentRepository.save(meetingBoardComment);
//	}
//	
//	// 삭제
//	public void removeMeetingBoardComment(Long id) {
//		
//		meetingBoardCommentRepository.deleteById(id);
//	}
//}
