package pl.kgdev.jobboard;



import org.junit.Test;
import org.mockito.Mockito;
import pl.kgdev.jobboard.entities.JobOffer;
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
        JobOffer jobOffer = new JobOffer("Junior Java",1L,1L,"Treść ogłoszenia na junior Java developera","FakeCompany",1L,3000);

        when(jobOfferRepository.save(any(JobOffer.class))).then(returnsElementsOf(new ArrayList<JobOffer>(Arrays.asList(jobOffer))));

        jobOfferRepository.save(jobOffer);

        JobOfferService jobOfferService = new JobOfferService(jobOfferRepository);

        JobOffer firstJobOffer = jobOfferService.findAll().get(0);

        assertEquals(jobOffer.getId(), firstJobOffer.getId());
        assertEquals(jobOffer.getId_category(), firstJobOffer.getId_category());
        assertEquals(jobOffer.getId_city(), firstJobOffer.getId_city());
        assertEquals(jobOffer.getContent(), firstJobOffer.getContent());
        assertEquals(jobOffer.getName(), firstJobOffer.getName());

    }
}
