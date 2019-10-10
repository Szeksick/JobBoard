package pl.kgdev.jobboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kgdev.jobboard.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
