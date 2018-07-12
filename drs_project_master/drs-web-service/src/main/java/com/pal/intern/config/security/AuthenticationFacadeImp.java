
package com.pal.intern.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacadeImp implements AuthenticationFacade{

    @Override
    public Authentication getAuthentication() {
       return SecurityContextHolder. getContext().getAuthentication();
    }

    @Override
    public String getUserName() {
        String userName  = null;
        Object principal =getAuthentication().getPrincipal();
        if(principal instanceof UserDetails ){
            userName = ((UserDetails)principal).getUsername();
        }else{
            userName = principal.toString();
        }
        
        return userName ;
        
    }
    
}
