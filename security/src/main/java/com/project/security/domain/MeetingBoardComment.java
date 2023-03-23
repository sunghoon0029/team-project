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
//public class MeetingBoardComment extends Base{
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	private String meeting_board_nickname;
//	
//	private String content;
//	
////	MeetingBoard(1) : MeetingBoardComment(N) 설정
////	@ManyToOne
//	@Column(name = "meeting_board_id")
//	private Long meeting_board_id;
//}
