package pl.kgdev.jobboard.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.kgdev.jobboard.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
