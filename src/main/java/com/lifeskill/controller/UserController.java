package com.lifeskill.controller;

import com.lifeskill.entity.User;
import com.lifeskill.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<User> getMe(Authentication authentication) {
        String username = authentication.getName();
        User user = userService.getUser(username);
        // Clear password before returning
        user.setPassword(null);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/me")
    public ResponseEntity<User> updateMe(Authentication authentication, @RequestBody User updateData) {
        String username = authentication.getName();
        User user = userService.updateUser(username, updateData);
        user.setPassword(null);
        return ResponseEntity.ok(user);
    }
}
