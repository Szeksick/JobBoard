package pl.kgdev.jobboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kgdev.jobboard.entities.JobOffer;
import pl.kgdev.jobboard.repositories.JobOfferRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class JobOfferController {

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @RequestMapping("/jobOffer/{jobOffer-name}")
    public String jobOffer(Model model, @PathVariable("jobOffer-name") String jobOfferName){
        model.addAttribute("jobOffer", jobOfferRepository.findByName(jobOfferName));
        return "jobOffer";
    }

    @RequestMapping("/admin/deletejoboffer/{jobOffer-name}")
    public String deleteJobOffer(HttpServletRequest request,Model model, @PathVariable("jobOffer-name") String jobOfferName){
        JobOffer jobOffer = jobOfferRepository.findByName(jobOfferName);
        jobOfferRepository.delete(jobOffer);
        return "redirect:/";
    }
}
