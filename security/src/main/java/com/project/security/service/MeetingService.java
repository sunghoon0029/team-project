package com.project.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.security.domain.Meeting;
import com.project.security.repository.MeetingRepository;

@Service
public class MeetingService {

	@Autowired
	private MeetingRepository meetingRepository;
	
	// 전체 조회
	public List<Meeting> getMeetingList() {
		
		return meetingRepository.findAll();
	}
	
	// 개별 조회
	public Optional<Meeting> getMeetingListById(Long id) {
		
		return meetingRepository.findById(id);
	}
	
	// 작성
	public Meeting registMeeting(Meeting meeting) {
		
		return meetingRepository.save(meeting);
	}
	
	// 수정
	public Meeting updateMeeting(Meeting meeting) {
		
		return meetingRepository.save(meeting);
	}
	
	// 삭제
	public void removeMeeting(Long id) {
		
		meetingRepository.deleteById(id);
	}
	
}
