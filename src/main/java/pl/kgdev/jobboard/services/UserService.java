package pl.kgdev.jobboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.kgdev.jobboard.entities.RoleEnum;
import pl.kgdev.jobboard.entities.User;
import pl.kgdev.jobboard.repositories.RoleRepository;
import pl.kgdev.jobboard.repositories.UserRepository;


import java.util.Arrays;

@Service
public class UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return  userRepository.findAll();
    }

    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User user = userRepository.findByUsername(currentUserName);
        return user;
    }

    public void saveUser(User user){
        user.setRoles(Arrays.asList(roleRepository.findByRole("USER")));
        user.setActive(true);
        userRepository.save(user);
    }
}
