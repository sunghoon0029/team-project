//package com.project.security.domain;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter @Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
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
////	public List<MeetingBoardComment> MeetingBoardComment;
//	
//}
