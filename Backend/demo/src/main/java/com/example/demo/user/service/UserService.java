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
        user.setPassword(password);
        saveUser(user);
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

    // 비밀번호를 암호화하여 저장하는 메소드
    public void saveUser(UserSet user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    // 비밀번호 변경 기능
    public UserSet changePassword(String username, String newPassword) {
        UserSet user = getUser(username);
        user.setPassword(newPassword);
        saveUser(user);
        return user;
    }

    // 사용자 삭제 기능
    public void deleteUser(String username) {
        UserSet user = getUser(username);
        this.userRepository.delete(user);
    }
}
