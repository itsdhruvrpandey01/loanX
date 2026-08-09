package com.loanx.authservice.service;

import com.loanx.authservice.dto.AuthResponse;
import com.loanx.authservice.dto.LoginRequest;
import com.loanx.authservice.dto.RegisterRequest;
import com.loanx.authservice.entity.User;
import com.loanx.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.username())) {
            throw new RuntimeException("Username already exists!");
        }

        User user = User.builder()
                .username(request.username())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role("ROLE_USER")
                .build();

        userRepository.save(user);
        String token = jwtService.generateToken(user.getUsername());
        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new RuntimeException("Invalid password!");
        }

        String token = jwtService.generateToken(user.getUsername());
        return new AuthResponse(token);
    }
}