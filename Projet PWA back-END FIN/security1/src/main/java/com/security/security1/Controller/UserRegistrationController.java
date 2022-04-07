package com.security.security1.Controller;

import com.security.security1.Service.UserService;
import com.security.security1.web.dto.UserRegistrationDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    UserService userService;

    @RequestMapping
    private String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "/registration";
    }

    @PostMapping
    private String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }

}
