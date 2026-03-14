package com.lifeskill.service;

import com.lifeskill.entity.User;
import com.lifeskill.exception.ResourceNotFoundException;
import com.lifeskill.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User getUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("사용자", username));
    }

    @Transactional
    public User updateUser(String username, User updateData) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("사용자", username));

        if (updateData.getName() != null) user.setName(updateData.getName());
        if (updateData.getGender() != null) user.setGender(updateData.getGender());
        if (updateData.getBirthDate() != null) user.setBirthDate(updateData.getBirthDate());
        if (updateData.getSchool() != null) user.setSchool(updateData.getSchool());
        if (updateData.getGrade() != null) user.setGrade(updateData.getGrade());
        if (updateData.getClassNum() != null) user.setClassNum(updateData.getClassNum());

        return userRepository.save(user);
    }
}
