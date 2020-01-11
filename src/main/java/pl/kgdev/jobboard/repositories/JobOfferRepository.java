package pl.kgdev.jobboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kgdev.jobboard.entities.Category;
import pl.kgdev.jobboard.entities.JobOffer;

import java.util.List;

@Repository
public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {
    List<JobOffer> findAllByCategory(Category category);
}
