package pl.kgdev.jobboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kgdev.jobboard.entities.User;
import pl.kgdev.jobboard.repositories.CategoryRepository;
import pl.kgdev.jobboard.repositories.JobOfferRepository;
import pl.kgdev.jobboard.services.UserService;

import javax.validation.Valid;


@Controller
public class HomeController{

    @Autowired
    private UserService userService;

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("jobOffers", jobOfferRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }

    @RequestMapping("/categories")
    public String categorylist(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist";
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, @RequestParam("password") String pw){
        System.out.println("pw: " + pw);
        if(result.hasErrors()){
            return "register";
        } else {
            userService.saveUser(user);
            model.addAttribute("message", "New User Account Created");
        }
        return "login";
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }
}
