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

import com.project.security.domain.Meeting;
import com.project.security.service.MeetingService;

@RestController
@RequestMapping("/meeting")
public class MeetingController {
	
	@Autowired
	private MeetingService meetingService;
	
	@GetMapping("/list")
	public List<Meeting> getAll() {
		
		return meetingService.getMeetingList();
	}
	
	@GetMapping("/list/{id}")
	public Optional<Meeting> getMeetingById(@PathVariable("id") Long id) {
		
		return meetingService.getMeetingListById(id);
	}
	
	@PostMapping("/regist")
	public Meeting registMeeting(@RequestBody Meeting meeting) {
		
		System.out.println(meeting);
		
		return meetingService.registMeeting(meeting);
	}
	
	@PutMapping("/update/{id}")
	public void updateMeeting(
			@PathVariable("id") Long id,
			@RequestBody Meeting meeting) {
		
		meetingService.updateMeeting(meeting);
	}
	
	@DeleteMapping("/delete/{id}")
	public void removeMeeting(@PathVariable Long id) {
		
		meetingService.removeMeeting(id);
	}

}
