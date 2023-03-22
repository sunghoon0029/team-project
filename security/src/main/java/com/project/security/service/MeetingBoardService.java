//package com.project.security.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.project.security.domain.MeetingBoard;
//import com.project.security.repository.MeetingBoardRepository;
//
//@Service
//public class MeetingBoardService {
//	
//	@Autowired
//	private MeetingBoardRepository meetingboardRepository;
//	
//	// 조회
//	public List<MeetingBoard> getMeetingBoardList() {
//		
//		return meetingboardRepository.findAll();
//	}
//	
//	// 작성
//	public MeetingBoard registMeetingBoard(MeetingBoard meetingBoard) {
//		
//		return meetingboardRepository.save(meetingBoard);
//	}
//	
//	// 수정
//	public MeetingBoard updateMeetingBoard(MeetingBoard meetingBoard) {
//		
//		return meetingboardRepository.save(meetingBoard);
//	}
//	
//	// 삭제
//	public void removeMeetingBoard(Long id) {
//		
//		meetingboardRepository.deleteById(id);
//	}
//
//}
