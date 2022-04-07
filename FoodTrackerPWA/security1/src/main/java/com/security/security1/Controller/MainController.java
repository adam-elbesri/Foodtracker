package com.security.security1.Controller;

import java.security.Principal;

import com.security.security1.Repository.EatenRepository;
import com.security.security1.Repository.FoodRepository;
import com.security.security1.Repository.UserRepository;
import com.security.security1.Model.Eaten;
import com.security.security1.Model.Food;
import com.security.security1.Model.User;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.minidev.json.JSONArray;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EatenRepository EatenRep;

    @Autowired
    FoodRepository FoodRep;

    @GetMapping("/api/eatens/get/{user}")
    @ResponseBody
    public String GetEatens(@PathVariable User user) {
        String jsonStr = JSONArray.toJSONString(EatenRep.findByUser(user));
        return jsonStr;
        // return "ID: " + email;

    }

    @PostMapping("/api/eatens/post")

    @ResponseBody
    public String addEaten(@RequestParam String user, @RequestParam long food, @RequestParam String date,
            @RequestParam double quantity) {

        User User1 = userRepository.findByEmail(user);
        Food Food1 = FoodRep.findById(food);
        Eaten eaten = new Eaten(quantity, date, User1, Food1);
        EatenRep.save(eaten);
        System.out.println("FIN DU SAVE2");
        return "hello";
    }

    @GetMapping("/api/users/email/{email}")
    @ResponseBody
    public User GetUsers(@PathVariable String email) {
        return userRepository.findByEmail(email);
    }

    @GetMapping("/api/currentuser")
    @ResponseBody
    public String GetCurrentuser(Principal principal) {
        return principal.getName();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/start")
    public String play() {
        return "redirect:indexVue.html";
    }

}
