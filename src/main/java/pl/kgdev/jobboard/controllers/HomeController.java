package pl.kgdev.jobboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kgdev.jobboard.repositories.CategoryRepository;
import pl.kgdev.jobboard.repositories.JobOfferRepository;


@Controller
public class HomeController{

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("jobOffers", jobOfferRepository.findAll());
        return "index";
    }

    @RequestMapping("/categories")
    public String categorylist(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist";
    }

}
