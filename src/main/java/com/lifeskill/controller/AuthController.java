package com.lifeskill.controller;

import com.lifeskill.dto.KakaoCompleteRequest;
import com.lifeskill.dto.LoginRequest;
import com.lifeskill.dto.LoginResponse;
import com.lifeskill.dto.SignupRequest;
import com.lifeskill.service.AuthService;
import com.lifeskill.service.KakaoOAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final KakaoOAuthService kakaoOAuthService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<LoginResponse> signup(@Valid @RequestBody SignupRequest request) {
        LoginResponse response = authService.signup(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/check-username")
    public ResponseEntity<Map<String, Boolean>> checkUsername(@RequestBody Map<String, String> request) {
        boolean exists = authService.checkUsername(request.get("username"));
        return ResponseEntity.ok(Map.of("exists", exists));
    }

    @GetMapping("/kakao/authorize")
    public ResponseEntity<Void> kakaoAuthorize() {
        String kakaoAuthUrl = kakaoOAuthService.getKakaoAuthorizationUrl();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(java.net.URI.create(kakaoAuthUrl));
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @PostMapping("/kakao")
    public ResponseEntity<LoginResponse> kakaoLogin(@RequestBody Map<String, String> request) {
        String code = request.get("code");
        LoginResponse response = kakaoOAuthService.processKakaoLogin(code);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/kakao/complete")
    public ResponseEntity<LoginResponse> completeKakaoProfile(
            Authentication authentication,
            @Valid @RequestBody KakaoCompleteRequest request) {
        String username = authentication.getName();
        LoginResponse response = kakaoOAuthService.completeProfile(username, request);
        return ResponseEntity.ok(response);
    }
}
