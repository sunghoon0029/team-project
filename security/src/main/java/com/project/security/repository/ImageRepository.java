package com.project.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.security.domain.Image;

public interface ImageRepository extends JpaRepository<Image, String>{

}
