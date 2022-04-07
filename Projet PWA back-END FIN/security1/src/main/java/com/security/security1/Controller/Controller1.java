package com.security.security1.Controller;

import com.security.security1.Model.Client;
import com.security.security1.Repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller1 {
    @Autowired
    ClientRepository labd;

    @RequestMapping("")
    public String viewHomePage() {
        return "/index";
    }

    @RequestMapping("/Profile")
    public String visitProfil() {
        return "redirect:/p1";
    }

    @RequestMapping("/AlimentsRub")
    public String alimentsRub() {
        return "redirect:/p2";
    }

    @RequestMapping("/p1")
    public String acl(Model model) {
        model.addAttribute("cl", new Client());
        return "/simple";
    }

    @RequestMapping("/addClient")

    public String acl(Client cli) {
        labd.save(cli);
        return "redirect:/p2";
    }
}
