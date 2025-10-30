package com.aluno.FrameBlog.services;

import com.aluno.FrameBlog.request.AuthRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService extends UserDetailsService {

    String getToken(AuthRequest auth);

    String validateJwtToken(String token);
}
