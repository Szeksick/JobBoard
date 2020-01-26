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
import pl.kgdev.jobboard.entities.User;
import pl.kgdev.jobboard.repositories.CategoryRepository;
import pl.kgdev.jobboard.repositories.CityRepository;
import pl.kgdev.jobboard.repositories.JobOfferRepository;
import pl.kgdev.jobboard.repositories.UserRepository;
import pl.kgdev.jobboard.services.UserService;

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

    @Autowired
    private UserService userService;

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
            return "addcity";
        }
        model.addAttribute("message", "Miasto "+city.getName()+" zostało dodane");
        cityRepository.save(city);
        return "addcity";
    }

    @RequestMapping("/admin/addcategory")
    public String addCategory(Model model){
        model.addAttribute("category", new Category());
        return "addcategory";
    }
    @PostMapping("/admin/processaddcategory")
    public String processaddcity(@Valid Category category, BindingResult result, Model model){
        if(result.hasErrors()) {
          return "addcategory";
        }
        model.addAttribute("message", "Kategoria "+category.getName()+" została dodana");
        categoryRepository.save(category);
        return "addcategory";
    }

    @RequestMapping( value="/admin/deletecategory/{category-name}")
    public String jobOfferListByCategory(Model model, @PathVariable("category-name") String categoryName){
        Category category = categoryRepository.findByName(categoryName);
        categoryRepository.delete(category);
        return "redirect:/categories";
    }

    @RequestMapping( value="/admin/deletecategory/{username}")
    public String deactivateUser(Model model, @PathVariable("username") String username){
        User user = userRepository.findByUsername(username);
        user.setActive(false);
        return "adminpanel";
    }

}
