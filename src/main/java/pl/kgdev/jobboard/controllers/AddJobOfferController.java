package pl.kgdev.jobboard.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kgdev.jobboard.entities.JobOffer;
import pl.kgdev.jobboard.repositories.CategoryRepository;
import pl.kgdev.jobboard.repositories.CityRepository;
import pl.kgdev.jobboard.repositories.JobOfferRepository;

import javax.validation.Valid;

@Controller
public class AddJobOfferController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @RequestMapping("/addjoboffer")
    public String addJoboffer(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("cities", cityRepository.findAll());
        return "addjoboffer";
    }

    @GetMapping("/processjoboffer")
    public String processJobOffer(@Valid JobOffer jobOffer, BindingResult result, Model model){
        if(result.hasErrors()) {
            for (ObjectError e : result.getAllErrors()) {
                System.out.println(e);
            }
        }
        jobOfferRepository.save(jobOffer);
        return "jobofferadded";
    }
}
