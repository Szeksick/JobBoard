package pl.kgdev.jobboard.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kgdev.jobboard.entities.JobOffer;
import pl.kgdev.jobboard.entities.RoleEnum;
import pl.kgdev.jobboard.entities.User;
import pl.kgdev.jobboard.repositories.CategoryRepository;
import pl.kgdev.jobboard.repositories.CityRepository;
import pl.kgdev.jobboard.repositories.JobOfferRepository;
import pl.kgdev.jobboard.services.UserService;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class AddJobOfferController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Autowired
    private UserService userService;


    @RequestMapping("/addjoboffer")
    public String addJoboffer(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("cities", cityRepository.findAll());
        model.addAttribute("jobOffer", new JobOffer());
        if(userService.getUser() != null){
            model.addAttribute("user", userService.getUser());
                return "addjoboffer";
        }
        return "redirect:/login";
    }

    @PostMapping("/processjoboffer")
    public String processJobOffer(@Valid JobOffer jobOffer, BindingResult result, Model model){
        if(result.hasErrors()) {
            for (ObjectError e : result.getAllErrors()) {
                System.out.println(e);
            }
        }
        jobOffer.setUser(userService.getUser());
        jobOffer.setDate(new Date());
        jobOfferRepository.save(jobOffer);
        model.addAttribute("message", "Ogłoszenie zostało dodane");
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("cities", cityRepository.findAll());
        model.addAttribute("jobOffer", new JobOffer());
        return "redirect:/addjoboffer";
    }
}
