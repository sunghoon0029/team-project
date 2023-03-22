//package com.project.security.domain;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import lombok.Data;
//
//@Entity
//@Data
//public class MeetingBoard {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	private String meeting_board_title;
//	
//	private String meeting_board_nickname;
//	
//	private String meeting_board_hit;
//	
////	Meeting(1) : MeetingBoard(N) 설정
////	@ManyToOne
//	@Column(name = "meeting_id")
//	private Long meeting_id;
//	
//////	MeetingBoard(1) : MeetingBoardComment(N) 설정
////	@OneToMany(mappedBy = "meeting_board_id")
////	public Set<MeetingBoardComment> MeetingBoardComment;
//	
//}
