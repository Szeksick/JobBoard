package pl.kgdev.jobboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kgdev.jobboard.entities.Company;
import pl.kgdev.jobboard.entities.User;
import pl.kgdev.jobboard.repositories.CityRepository;
import pl.kgdev.jobboard.services.UserService;

import javax.validation.Valid;

@Controller
public class LoginRegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("cities", cityRepository.findAll());
        return "register";
    }

    @GetMapping("/register/company")
    public String showCompanyRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("cities", cityRepository.findAll());
        return "registerCompany";
    }

    @PostMapping("/register/company")
    public String processCompanyRegistrationPage(@Valid @ModelAttribute("user") User user, @ModelAttribute("company") Company company, BindingResult result, Model model, @RequestParam("password") String password) {
        if (result.hasErrors()) {
            return "registerCompany";
        } else {
            user.encode(password);
            user.setCompany(company);
            userService.saveCompany(user);
            model.addAttribute("message", "Nowe konto firmowe zostało założone");
        }
        return "login";
    }

    @PostMapping("/register")
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user, @ModelAttribute("company") Company company, BindingResult result, Model model, @RequestParam("password") String password) {
        if (result.hasErrors()) {
            return "register";
        } else {
            user.encode(password);
            userService.saveUser(user);
            user.setCompany(null);
            model.addAttribute("message", "Nowe konto użytkownika zostało założone");

        }
        return "login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }


}
