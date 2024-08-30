package com.example.springwebregistration.controller;


import com.example.springwebregistration.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    UserDto user;

    @GetMapping("/register")
    public String home(Model model){
        user = new UserDto();
        model.addAttribute("user", user);
       return "register";
    }

    @PostMapping("/register/save")
    public String registerSave(@ModelAttribute("user") UserDto user){
        this.user.setFirstName(user.getFirstName());
        this.user.setLastName(user.getLastName());
        this.user.setEmail(user.getEmail());
        return "redirect:/result";
    }

    @GetMapping("/result")
    public String result(Model model) {
        model.addAttribute("user", user);
        return "result";
    }
}
