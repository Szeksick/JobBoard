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

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void saveUser(User user){
        user.setRoles(Arrays.asList(roleRepository.findByRole(RoleEnum.USER.name())));
        user.setActive(true);
        userRepository.save(user);
    }

    public void saveCompany(User user){
        user.setRoles(Arrays.asList(roleRepository.findByRole(RoleEnum.COMPANY.name())));
        user.setActive(true);
        userRepository.save(user);
    }

    public void saveAdmin(User user){
        user.setRoles(Arrays.asList(roleRepository.findByRole(RoleEnum.ADMIN.name())));
        user.setActive(true);
        userRepository.save(user);
    }


    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User user = userRepository.findByUsername(currentUserName);
        return user;
    }
}
