package pl.kgdev.jobboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kgdev.jobboard.entities.User;
import pl.kgdev.jobboard.services.UserService;

import javax.validation.Valid;

@Controller
public class LoginRegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, @RequestParam("password") String password){
        System.out.println("pw: " + password);
        if(result.hasErrors()){
            return "register";
        } else {
            user.encode(password);
            userService.saveUser(user);
            model.addAttribute("message", "Nowe konto użytkownika zostało założone");
        }
        return "login";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }



}
