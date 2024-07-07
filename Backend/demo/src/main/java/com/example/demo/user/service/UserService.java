package com.example.demo.user.service;

import com.example.demo.user.domain.UserSet;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserSet create(String username, String email, String password) {
        Optional<UserSet> existingUser = userRepository.findByUsername(username);
        if (existingUser.isPresent()) {
            throw new DataNotFoundException("이미 존재하는 사용자입니다.");
        }

        UserSet user = new UserSet();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }

    public UserSet getUser(String username) {
        Optional<UserSet> user = this.userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new DataNotFoundException("사용자를 찾을 수 없습니다.");
        }
    }
}