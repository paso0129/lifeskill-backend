package com.lifeskill.service;

import com.lifeskill.dto.LoginRequest;
import com.lifeskill.dto.LoginResponse;
import com.lifeskill.dto.SignupRequest;
import com.lifeskill.entity.User;
import com.lifeskill.enums.UserRole;
import com.lifeskill.repository.UserRepository;
import com.lifeskill.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public LoginResponse signup(SignupRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .gender(request.getGender())
                .birthDate(request.getBirthDate())
                .school(request.getSchool())
                .grade(request.getGrade())
                .classNum(request.getClassNum())
                .role(UserRole.valueOf(request.getRole()))
                .provider("LOCAL")
                .profileComplete(true)
                .build();

        userRepository.save(user);

        String token = jwtTokenProvider.createToken(user.getUsername(), user.getRole().name());

        return LoginResponse.builder()
                .token(token)
                .profileComplete(true)
                .role(user.getRole().name())
                .name(user.getName())
                .build();
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtTokenProvider.createToken(user.getUsername(), user.getRole().name());

        return LoginResponse.builder()
                .token(token)
                .profileComplete(user.isProfileComplete())
                .role(user.getRole().name())
                .name(user.getName())
                .build();
    }

    public boolean checkUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
