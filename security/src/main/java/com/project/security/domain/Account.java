package com.project.security.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "account")
public class Account implements UserDetails {
	
	@Id @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(length = 100)
	private String nickname;
	
//	@Column(length = 100)
	private String email;
	
//	@Column(length = 200)
	private String password;
	
//	@Column(length = 30)
	private String gender;
	
//	@Column(length = 30)
	private LocalDate birthday;
	
	private int age;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private String created_at;
	
//	Account(1) : ReadingProgress(N) 설정
	@OneToMany(mappedBy = "account_id")
	public Set<ReadingProgress> readingProgress;
	
//	Account(1) : ReadingNote(N) 설정
	@OneToMany(mappedBy = "account_id")
	public Set<ReadingNote> readingNote;
	
//	Account(1) : ReadingNoteComment(N) 설정
	@OneToMany(mappedBy = "account_id")
	public Set<ReadingNoteComment> readingNoteComment;
	
//    @PrePersist
//    public void createdAt() {
//        this.created_at = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//    }
    
//	@Builder
//	public Account(String nickname, String email, String password, String gender, LocalDate birthday, int age, String created_at, Role role) {
//		this.nickname = nickname;
//        this.email = email;
//        this.password = password;
//        this.gender = gender;
//        this.birthday = birthday;
//        this.age = age;
//        this.created_at = created_at;
//        this.role = role;
//	}
	
    @JsonIgnore
    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();   
         authorities.add(new SimpleGrantedAuthority("yes"));
         return authorities;
	}
    @JsonIgnore
	@Override
	public String getUsername() {
		return email;
	}
    @JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
    @JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
    @JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
    @JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

}
