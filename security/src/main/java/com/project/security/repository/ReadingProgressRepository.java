package com.project.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.security.domain.ReadingProgress;

public interface ReadingProgressRepository extends JpaRepository<ReadingProgress, Long> {

}
