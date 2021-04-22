package com.project.phonedir.controller;

import com.project.phonedir.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.phonedir.controller.UserController;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "index";
    }

}
