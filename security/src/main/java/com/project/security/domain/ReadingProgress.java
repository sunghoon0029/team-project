package com.project.security.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReadingProgress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String reading_progress_title;
	
	private Integer reading_progress_goal;
	
	private Integer reading_progress_attainment;
	
	private Integer attainment_percent;

	
	// Account(1) : ReadingProgress(N) 설정
	@ManyToOne
	@JoinColumn(name="account_id")
	@JsonIgnoreProperties({"readingProgress"})
	private Account account;
	
}
