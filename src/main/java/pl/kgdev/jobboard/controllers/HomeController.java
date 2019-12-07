package pl.kgdev.jobboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kgdev.jobboard.entities.JobOffer;
import pl.kgdev.jobboard.repositories.CategoryRepository;
import pl.kgdev.jobboard.repositories.JobOfferRepository;

import javax.validation.Valid;

@Controller
public class HomeController{

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("jobOffers", jobOfferRepository.findAll());
        return "index";
    }

}
