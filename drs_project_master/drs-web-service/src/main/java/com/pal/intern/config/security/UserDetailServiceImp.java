package com.pal.intern.config.security;

import com.pal.intern.domain.User;
import com.pal.intern.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = this.userService.getUserByUserName(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("user name not found");
        }
        return new UserPrincipal(user.get());
    }

}
