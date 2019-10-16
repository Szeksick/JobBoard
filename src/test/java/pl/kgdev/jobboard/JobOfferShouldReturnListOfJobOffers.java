package pl.kgdev.jobboard;



import org.junit.Test;
import org.mockito.Mockito;
import pl.kgdev.jobboard.entities.Category;
import pl.kgdev.jobboard.entities.City;
import pl.kgdev.jobboard.entities.JobOffer;
import pl.kgdev.jobboard.entities.User;
import pl.kgdev.jobboard.repositories.JobOfferRepository;
import pl.kgdev.jobboard.services.JobOfferService;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalAnswers.returnsElementsOf;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class JobOfferShouldReturnListOfJobOffers {

    private JobOfferRepository jobOfferRepository = Mockito.mock(JobOfferRepository.class);

    @Test
    public void getAllJobOffers(){
        JobOffer jobOffer = new JobOffer("Junior Java",new Category("Praca w kopalni"),new City("New York"),"Treść ogłoszenia na junior Java developera","FakeCompany",new User("asd","asd","asd","asd","asd","asd"),3000);

        when(jobOfferRepository.save(any(JobOffer.class))).then(returnsElementsOf(new ArrayList<JobOffer>(Arrays.asList(jobOffer))));

        jobOfferRepository.save(jobOffer);

        JobOfferService jobOfferService = new JobOfferService(jobOfferRepository);

        JobOffer firstJobOffer = jobOfferService.findAll().get(0);

        assertEquals(jobOffer.getId(), firstJobOffer.getId());
        assertEquals(jobOffer.getCategory(), firstJobOffer.getCategory());
        assertEquals(jobOffer.getCity(), firstJobOffer.getCity());
        assertEquals(jobOffer.getContent(), firstJobOffer.getContent());
        assertEquals(jobOffer.getName(), firstJobOffer.getName());

    }
}
