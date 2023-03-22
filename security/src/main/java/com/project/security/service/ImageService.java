package com.project.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.security.domain.Image;
import com.project.security.repository.ImageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {
	
	private final ImageRepository imageRepository;
	
	public List<Image> getImage(){
		
		return imageRepository.findAll();
	}
	
	

}
