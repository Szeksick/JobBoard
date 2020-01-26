package pl.kgdev.jobboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kgdev.jobboard.entities.Company;
import pl.kgdev.jobboard.entities.User;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    public Company findByUser(User user);
}
