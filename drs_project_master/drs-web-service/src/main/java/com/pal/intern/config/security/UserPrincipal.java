package com.pal.intern.config.security;

import com.pal.intern.domain.Role;
import com.pal.intern.domain.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

    private User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> listOfGrantedAuthoritys = new ArrayList<>();
        Set<Role> userRoles = this.getUser().getPermission();
        if (!userRoles.isEmpty()) {
            userRoles.forEach(e -> {
                listOfGrantedAuthoritys.add(new SimpleGrantedAuthority(e.getRoleName()));

            });
        }
        return listOfGrantedAuthoritys;
    }

    @Override
    public String getPassword() {
        return this.getUser().getPassword();
    }

    @Override
    public String getUsername() {
        return this.getUser().getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.getUser().getStatus() != 3;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.getUser().getStatus() != 2;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.getUser().getStatus() == 1;
    }

}
