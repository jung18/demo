package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.core.userdetails.User;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index"; // index.html 파일을 반환합니다.
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model, @AuthenticationPrincipal Object principal) {
        if (principal instanceof User) {
            User user = (User) principal;
            model.addAttribute("username", user.getUsername());
        } else if (principal instanceof OAuth2User) {
            OAuth2User oauth2User = (OAuth2User) principal;
            model.addAttribute("username", oauth2User.getAttribute("name"));
        }
        return "home"; // home.html 파일을 반환합니다.
    }
}
