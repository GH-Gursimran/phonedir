package com.project.phonedir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homecontroller {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

}
