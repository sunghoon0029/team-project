package com.project.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.security.domain.Meeting;

public interface MeetingRepository extends JpaRepository<Meeting, Long>{

}
