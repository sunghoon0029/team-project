package com.project.security.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "account")
public class Account implements UserDetails {
	
	@Id @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nickname;
	
	private String email;
	
	private String password;
	
	private String gender;
	
	private LocalDate birthday;
	
	private int age;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private String created_at;
	
	
	// Account(1) : ReadingProgress(N) 설정
	@OneToMany(mappedBy="account", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"account"})
	@Builder.Default
	private List<ReadingProgress> readingProgress = new ArrayList<>();
	
	// Account(1) : ReadingNote(N) 설정
	@OneToMany(mappedBy="account", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"account"})
	@Builder.Default
	private List<ReadingNote> readingNote = new ArrayList<>();
	
	// Account(1) : ReadingNoteComment(N) 설정
	@OneToMany(mappedBy="account", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"account"})
	@Builder.Default
	private List<ReadingNoteComment> readingNoteComment = new ArrayList<>();
	
//	// Account(1) : Meeting(N) 설정
//	@OneToMany(mappedBy = "account_id")
//	public List<Meeting> meeting;
	

    @JsonIgnore
    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();   
         authorities.add(new SimpleGrantedAuthority("user"));
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
