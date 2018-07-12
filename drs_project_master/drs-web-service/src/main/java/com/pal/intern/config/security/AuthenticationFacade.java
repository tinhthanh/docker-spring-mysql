package com.pal.intern.config.security;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {

    public Authentication getAuthentication();
    
    public String getUserName();
}
