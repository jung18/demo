package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index"; // index.html 파일을 반환합니다.
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model, @AuthenticationPrincipal User user) {
        if (user != null) {
            model.addAttribute("username", user.getUsername());
        }
        return "home"; // home.html 파일을 반환합니다.
    }
}
