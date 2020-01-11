package pl.kgdev.jobboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.kgdev.jobboard.entities.JobOffer;
import pl.kgdev.jobboard.repositories.CategoryRepository;
import pl.kgdev.jobboard.repositories.JobOfferRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class JobOfferListController {
    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping( value="/offers/{category-name}")
    public String jobOfferListByCategory(Model model, @PathVariable("category-name") String categoryName){
        model.addAttribute("header",categoryName);
        model.addAttribute("jobOffers", jobOfferRepository.findAllByCategory(categoryRepository.findByName(categoryName)));
        return "jobOfferList";
    }

    @RequestMapping( value="/search/{search-querry}")
    public String jobOfferListBySearchQuerry(Model model, @PathVariable("search-querry") String searchQuerry){
        List<JobOffer> jobOfferList = new ArrayList<>();

        if (searchQuerry != null) {
            jobOfferList.addAll(jobOfferRepository.findAll().stream().filter(jobOffer -> containsIgnoreCase(jobOffer.toString(), searchQuerry)).collect(Collectors.toList()));
        }

        model.addAttribute("header", searchQuerry);
        model.addAttribute("jobOffers", jobOfferList);

        return "jobOfferList";
    }

    private boolean containsIgnoreCase(String src, String what) {
        final int length = what.length();
        if (length == 0)
            return true;

        final char firstLo = Character.toLowerCase(what.charAt(0));
        final char firstUp = Character.toUpperCase(what.charAt(0));

        for (int i = src.length() - length; i >= 0; i--) {
            final char ch = src.charAt(i);
            if (ch != firstLo && ch != firstUp)
                continue;

            if (src.regionMatches(true, i, what, 0, length))
                return true;
        }

        return false;
    }

}
