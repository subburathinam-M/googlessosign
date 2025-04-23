package com.googlessosignin.googlessosignin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.googlessosignin.googlessosignin.entity.AppUser;
import com.googlessosignin.googlessosignin.repository.AppUserRepository;
import org.springframework.ui.Model;

@Controller
public class MainController {
 @Autowired
    private AppUserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<AppUser> users = userRepository.findAll();
        model.addAttribute("users", users); // Passing user data to the view
        return "home"; // Return the home view
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // loads login.html
    }


}
