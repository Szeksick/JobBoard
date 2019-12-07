package pl.kgdev.jobboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kgdev.jobboard.entities.JobOffer;

@Repository
public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {
}
