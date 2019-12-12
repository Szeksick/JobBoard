package pl.kgdev.jobboard.services;

import org.springframework.stereotype.Service;
import pl.kgdev.jobboard.entities.JobOffer;
import pl.kgdev.jobboard.repositories.JobOfferRepository;

import java.util.List;

@Service
public class JobOfferService {

    private JobOfferRepository jobOfferRepository;

    public JobOfferService(JobOfferRepository jobOfferRepository) {
        this.jobOfferRepository = jobOfferRepository;
    }

    public List<JobOffer> findAll() {
        return jobOfferRepository.findAll();
    }
}
