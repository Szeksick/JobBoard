package pl.kgdev.jobboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kgdev.jobboard.entities.User;
import pl.kgdev.jobboard.repositories.CompanyRepository;
import pl.kgdev.jobboard.repositories.UserRepository;
import pl.kgdev.jobboard.services.UserService;

@Controller
public class UserProfileControler {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyRepository companyRepository;

    @RequestMapping("/myprofile")
    public String userProfile(Model model){
        User user = userService.getUser();
        if(user.isCompanyProfile()){
            model.addAttribute("company", companyRepository.findByUser(user));
        }
        model.addAttribute("user", user);
        return "profile";
    }

}
