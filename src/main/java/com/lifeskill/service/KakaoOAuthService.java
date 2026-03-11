package com.lifeskill.service;

import com.lifeskill.dto.KakaoCompleteRequest;
import com.lifeskill.dto.LoginResponse;
import com.lifeskill.entity.User;
import com.lifeskill.enums.UserRole;
import com.lifeskill.repository.UserRepository;
import com.lifeskill.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class KakaoOAuthService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Value("${kakao.client-id:}")
    private String kakaoClientId;

    @Value("${kakao.redirect-uri:}")
    private String kakaoRedirectUri;

    private final RestTemplate restTemplate = new RestTemplate();

    @Transactional
    public LoginResponse processKakaoLogin(String code) {
        // 1. Exchange authorization code for access token
        String accessToken = getAccessToken(code);

        // 2. Get user info from Kakao
        Map<String, Object> userInfo = getKakaoUserInfo(accessToken);

        String kakaoId = String.valueOf(userInfo.get("id"));

        @SuppressWarnings("unchecked")
        Map<String, Object> kakaoAccount = (Map<String, Object>) userInfo.get("kakao_account");

        @SuppressWarnings("unchecked")
        Map<String, Object> profile = kakaoAccount != null
                ? (Map<String, Object>) kakaoAccount.get("profile")
                : null;

        String nickname = profile != null ? (String) profile.get("nickname") : "KakaoUser";

        // 3. Find or create user
        User user = userRepository.findByKakaoId(kakaoId)
                .orElseGet(() -> {
                    User newUser = User.builder()
                            .username("kakao_" + kakaoId)
                            .name(nickname)
                            .provider("KAKAO")
                            .kakaoId(kakaoId)
                            .role(UserRole.STUDENT)
                            .profileComplete(false)
                            .build();
                    return userRepository.save(newUser);
                });

        String token = jwtTokenProvider.createToken(user.getUsername(), user.getRole().name());

        return LoginResponse.builder()
                .token(token)
                .profileComplete(user.isProfileComplete())
                .role(user.getRole().name())
                .name(user.getName())
                .build();
    }

    @Transactional
    public LoginResponse completeProfile(String username, KakaoCompleteRequest request) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setSchool(request.getSchool());
        user.setGrade(request.getGrade());
        user.setClassNum(request.getClassNum());
        user.setRole(UserRole.valueOf(request.getRole()));
        user.setProfileComplete(true);

        userRepository.save(user);

        String token = jwtTokenProvider.createToken(user.getUsername(), user.getRole().name());

        return LoginResponse.builder()
                .token(token)
                .profileComplete(true)
                .role(user.getRole().name())
                .name(user.getName())
                .build();
    }

    private String getAccessToken(String code) {
        String tokenUrl = "https://kauth.kakao.com/oauth/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", kakaoClientId);
        params.add("redirect_uri", kakaoRedirectUri);
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        @SuppressWarnings("unchecked")
        Map<String, Object> response = restTemplate.postForObject(tokenUrl, request, Map.class);

        if (response == null || !response.containsKey("access_token")) {
            throw new RuntimeException("Failed to get Kakao access token");
        }

        return (String) response.get("access_token");
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> getKakaoUserInfo(String accessToken) {
        String userInfoUrl = "https://kapi.kakao.com/v2/user/me";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);

        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                userInfoUrl, HttpMethod.GET, request, Map.class);

        if (response.getBody() == null) {
            throw new RuntimeException("Failed to get Kakao user info");
        }

        return response.getBody();
    }
}
