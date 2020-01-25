package pl.kgdev.jobboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kgdev.jobboard.entities.Category;
import pl.kgdev.jobboard.entities.City;
import pl.kgdev.jobboard.repositories.CategoryRepository;
import pl.kgdev.jobboard.repositories.CityRepository;
import pl.kgdev.jobboard.repositories.JobOfferRepository;
import pl.kgdev.jobboard.repositories.UserRepository;

import javax.validation.Valid;

@Controller
public class AdministrationPanelController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @RequestMapping("/admin")
    public String panelpage(Model model)
    {
        model.addAttribute("jobOffers", jobOfferRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "adminpanel";
    }

    @RequestMapping("/admin/addcity")
    public String addCity(Model model){
        model.addAttribute("city", new City());
        return "addcity";
    }
    @PostMapping("/admin/processaddcity")
    public String processaddcity(@Valid City city, BindingResult result, Model model){
        if(result.hasErrors()) {
            for (ObjectError e : result.getAllErrors()) {
                System.out.println(e);
            }
        }
        cityRepository.save(city);
        return "redirect:/admin";
    }

    @RequestMapping("/admin/addcategory")
    public String addCategory(Model model){
        model.addAttribute("category", new Category());
        return "addcategory";
    }
    @PostMapping("/admin/processaddcategory")
    public String processaddcity(@Valid Category category, BindingResult result, Model model){
        if(result.hasErrors()) {
            for (ObjectError e : result.getAllErrors()) {
                System.out.println(e);
            }
        }
        categoryRepository.save(category);
        return "redirect:/admin";
    }

    @RequestMapping( value="/admin/deletecategory/{category-name}")
    public String jobOfferListByCategory(Model model, @PathVariable("category-name") String categoryName){
        Category category = categoryRepository.findByName(categoryName);
        categoryRepository.delete(category);
        return "redirect:/categories";
    }

}
