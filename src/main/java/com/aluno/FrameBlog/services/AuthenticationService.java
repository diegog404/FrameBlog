package com.aluno.FrameBlog.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.aluno.FrameBlog.request.AuthRequest;

public interface AuthenticationService extends UserDetailsService{

	String getToken(AuthRequest auth);

	String validateJwtToken(String token);
}
