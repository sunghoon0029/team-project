package com.project.security.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.security.domain.Image;
import com.project.security.service.ImageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ImageController {

	private final ImageService imageService;
	
	// 이미지 추가
	@PostMapping(value = "/image/add", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public void addImage(@RequestPart Image image, @RequestPart MultipartFile multipartFile) {
		log.info("이름 : {}, 나이 : {}, 이미지 : {}", image.getId(), image.getName(), multipartFile);
	}
	
	// 이미지 조회
	@GetMapping(value = "image/view")
	public List<Image> getImage(Image image) {
		
		return imageService.getImage();
	}
	
}
