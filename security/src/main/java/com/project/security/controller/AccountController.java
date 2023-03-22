package com.project.security.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.security.domain.Account;
import com.project.security.domain.Image;
import com.project.security.jwt.JwtToken;
import com.project.security.jwt.JwtTokenProvider;
import com.project.security.jwt.SecurityUtil;
import com.project.security.repository.AccountRepository;
import com.project.security.service.AccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
	
	private final AccountRepository accountRepository;
	private final AccountService accountService;
	private final PasswordEncoder passwordEncoder;
	private final JwtTokenProvider jwtTokenProvider;
//	private final ImageService imageService;
	
	// 회원가입
	@PostMapping("/join")
	public Account join(@RequestBody Account account) {
		
		return accountService.join(account);
	}
	
	// JWT 로그인
	@PostMapping("/login")
	@CrossOrigin(origins = "*", exposedHeaders = "Authorization")
	public JwtToken Login(@RequestBody Map<String, String> user) {
		Account account = accountRepository.findByEmail(user.get("email"))
						.orElseThrow(() -> new IllegalArgumentException("가입 되지 않은 아이디 입니다."));
		if (!(user.get("password").equals(account.getPassword()))) {
			throw new IllegalArgumentException("아이디 또는 비밀번호가 맞지않습니다.");
		}
		JwtToken jwtToken = accountService.login(account.getEmail(), account.getPassword());
		return jwtToken;
	}
	
	// JWT 로그아웃
	@PostMapping("/logout")
	public ResponseEntity<Void> logout(@RequestHeader("Authorization") String accessToken) {
		accountService.logout(accessToken);
		System.out.println("로그아웃성공");
		return new ResponseEntity(HttpStatus.OK);
	}
	
	// 권한 Test
	@PostMapping("/yes/test")
	public String test() {
		System.out.println("@@@" + SecurityContextHolder.getContext().getAuthentication().getName() + "@@@");
		System.out.println("email: " + SecurityUtil.getCurrentAccountEmail());
		return "Test 성공";
	}
	
	// 사용자 조회
	@GetMapping("/list")
	public List<Account> getAccount(Account account) {
		
		return accountService.getAccountList();
	}
	
	// 사용자 개별 조회
	@GetMapping("/list/{id}")
	public Optional<Account> getAccountById(@PathVariable("id") Long id) {
		
		return accountService.getAccountListById(id);
	}
	
	// 회원정보 수정
	@PutMapping("/update/{id}")
	public void updateAccount(
			@PathVariable("id") Long id,
			@RequestBody Account account) {
		
		accountService.updateAccount(account);
	}
	
	// 사용자 삭제
	@DeleteMapping("/delete/{id}")
	public void removeAccount(@PathVariable Long id) {
		
		accountService.removeAccount(id);
	}
	
//	// 이미지 추가
//	@PostMapping(value = "/image/add", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
//	public void addImage(@RequestPart Image image, @RequestPart MultipartFile imgFile) {
//		log.info("이름 : {}, 나이 : {}, 이미지 : {}", image.getName(), imgFile);
//	}
	
//	// 이미지 조회
//	@GetMapping("/image/view")
//	public void getImage(Image image) {
//		
//		imageService.getImage();
//	}
	
}
