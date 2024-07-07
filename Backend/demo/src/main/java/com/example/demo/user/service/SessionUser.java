package com.example.demo.user.service;

import com.example.demo.user.domain.User;
import lombok.Getter;

@Getter
public class SessionUser {
    private String name;
    private String email;

    public SessionUser(User user) {
        this.name = user.getUsername();
        this.email = user.getEmail();
    }
}
