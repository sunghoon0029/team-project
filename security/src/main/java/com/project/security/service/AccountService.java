package com.project.security.service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.security.domain.Account;
import com.project.security.domain.Role;
import com.project.security.jwt.JwtToken;
import com.project.security.jwt.JwtTokenProvider;
import com.project.security.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	private final JwtTokenProvider jwtTokenProvider;
	private final AuthenticationManagerBuilder authenticationManagerBuilder;
	private final RedisTemplate redisTemplate;
	
    // JWT 로그인
	public JwtToken login(String email, String password) {
		// 1. Login ID/PW 를 기반으로 Authentication 객체 생성
		// 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);

		// 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
		// authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername
		// 메서드가 실행
		Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

		// 3. 인증 정보를 기반으로 JWT 토큰 생성
		JwtToken jwtToken = jwtTokenProvider.generateToken(authentication);

		return jwtToken;
	}
	
	// JWT 사용자 정보 반환
	public Optional<Account> searchAccount(String email) {
		return accountRepository.findByEmail(email);
	}
	
	// JWT 로그아웃
	@Transactional
	public void logout(String accessToken) {
		Long expiration = jwtTokenProvider.getExpiration(accessToken);

		redisTemplate.opsForValue().set(accessToken, "blackList", expiration, TimeUnit.MILLISECONDS);
	}
	
    // 회원 조회
	public List<Account> getAccountList() {
		
		return accountRepository.findAll();
	}
	
	// 회원 개별 조회
	public Optional<Account> getAccountListById(Long id) {
		
		return accountRepository.findById(id);
	}
	
	// 회원가입
	public Account join(Account account) {
		
		account.setRole(Role.user);
		
		// 작성일자 문자열 변경
		LocalDateTime nowDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		
		account.setCreated_at(nowDateTime.format(formatter));
		
		// 현재일자와 생년월일을 이용한 만나이 계산
		LocalDate birthday = account.getBirthday();
		LocalDate nowDate = LocalDate.now();
		
		account.setAge(nowDate.getYear() - birthday.getYear());
		
		return accountRepository.save(account);
	}
	
	// 회원정보 수정
	public Account updateAccount(Account account) {
		
		account.setRole(Role.user);
		
		// 작성일자 문자열 변경
		LocalDateTime nowDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		
		account.setCreated_at(nowDateTime.format(formatter));
		
		// 현재일자와 생년월일을 이용한 만나이 계산
		LocalDate birthday = account.getBirthday();
		LocalDate nowDate = LocalDate.now();
		
		account.setAge(nowDate.getYear() - birthday.getYear());
		
		return accountRepository.save(account);
	}
	
	// 회원 삭제
	public void removeAccount(Long id) {
		
		accountRepository.deleteById(id);
	}
	
	public Optional<Account> accountId(String id) {
		return accountRepository.findByEmail(id);
	}
        
}
