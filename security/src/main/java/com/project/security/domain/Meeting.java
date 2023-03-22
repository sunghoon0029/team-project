package com.project.security.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Meeting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String meeting_title;
	
	private int max_num;
	
	private String hashtag;
	
	private String category;
	
	private String meeting_status;
	
	private String location;
	
	private String introduce;
	
	private String first_date;
	
	private int gender_percent;
	
//	Account(1) : Meeting(N) 설정
//	@ManyToOne
	@Column(name = "account_id")
	private Long account_id;
	
////	Meeting(1) : MeetingBoard(N) 설정
//	@OneToMany(mappedBy = "meeting_id")
//	public Set<Meeting> meeting;

}
