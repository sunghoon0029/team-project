package com.project.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.security.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByEmail(String email);
}
