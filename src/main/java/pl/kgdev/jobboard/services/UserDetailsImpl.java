package pl.kgdev.jobboard.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.kgdev.jobboard.entities.User;

import java.util.Collection;
import java.util.Set;

public class UserDetailsImpl extends org.springframework.security.core.userdetails.User {

    private User user;

    public UserDetailsImpl(User user, Set<GrantedAuthority> authorities) {
        super(user.getUsername(),user.getPassword(),authorities);
        this.user = user;
    }
}
