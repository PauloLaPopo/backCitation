package com.example.backcitation.repository.authentication;

import com.example.backcitation.model.BlackListedToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListedTokenRepository extends JpaRepository<BlackListedToken, String> {
}
