package com.lifeskill.service;

import com.lifeskill.dto.LoginRequest;
import com.lifeskill.dto.LoginResponse;
import com.lifeskill.dto.SignupRequest;
import com.lifeskill.entity.User;
import com.lifeskill.enums.UserRole;
import com.lifeskill.exception.BusinessException;
import com.lifeskill.exception.DuplicateResourceException;
import com.lifeskill.exception.ResourceNotFoundException;
import com.lifeskill.repository.UserRepository;
import com.lifeskill.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
            throw new DuplicateResourceException("이미 사용 중인 아이디입니다.");
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
                .orElseThrow(() -> new ResourceNotFoundException("사용자", request.getUsername()));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BusinessException("비밀번호가 일치하지 않습니다.", HttpStatus.UNAUTHORIZED);
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
