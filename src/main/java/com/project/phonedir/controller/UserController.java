package com.project.phonedir.controller;

import com.project.phonedir.model.User;
import com.project.phonedir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // GET Request to "/users/login
    @RequestMapping(method = RequestMethod.GET, value = "/users/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "users/login";
    }

    // POST Request to "/users/login"
    @RequestMapping(method = RequestMethod.POST, value = "/users/login")
    public String loginUser(User user, HttpSession session) {
        System.out.println(user.getPassword() +  user.getUsername());
        User existingUser = userService.login(user);

        // check if the credentials match
        if(existingUser != null) {
            // Creating User Session
            session.setAttribute("LoggedUser", existingUser);
            System.out.println("USER FOUND!!");
            return "redirect:/phonedirs";
        } else {
            System.out.println("USER DOES NOT EXIST!!");
            return "index";
        }
    }

    // AGENDA 3 : Create the user registration
    // Registration :- "/users/registration"
    // Logout :- "/users/logout

    @RequestMapping(method = RequestMethod.GET, value = "/users/registration")
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "users/registration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/registration")
    public String userRegistration(User user) {
        // Business logic to save the credentials. of the users to teh given database
        boolean status = userService.registerUser(user);

        if(status){
            userService.login(user);
            return "redirect:/phonedirs";
        }else {
            return "index";
        }

    }

    @RequestMapping("/users/logout")
    public String userLogout() {
        return "redirect:/";
    }
}
