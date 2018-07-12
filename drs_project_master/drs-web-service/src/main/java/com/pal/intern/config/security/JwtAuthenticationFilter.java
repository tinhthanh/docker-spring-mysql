package com.pal.intern.config.security;

import com.pal.intern.config.jwt.JwtService;
import io.jsonwebtoken.ExpiredJwtException;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String userName = null;
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");

        /**
         * get token from request
         */
        String authToken = this.jwtService.getToken(request);
        
      
   

        LOGGER.info(authToken + " [token value]");

        if (authToken != null) {
            try {
                userName = this.jwtService.getUserNameFromToKen(authToken);

                LOGGER.info(userName + " [user name from token]");

            } catch (IllegalArgumentException e) {
                LOGGER.error("Error when call method doFilterInternal() with param " + Arrays.asList(request,response,filterChain ), e);
            } catch (ExpiredJwtException e) {
                LOGGER.warn("The token is expired and not valid anymore at method doFilterInternal()", e);
            }
        } else {
            LOGGER.warn("Couldn't find bearer string, will ignore the header at method doFilterInternal()");
        }

        LOGGER.info("checking authentication for user " + userName);
        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);

            if (this.jwtService.validateToken(authToken, userDetails)) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                LOGGER.info("authenticated user " + userName + ", setting security context");
                SecurityContextHolder.getContext().setAuthentication(authentication);

                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, PATCH");
                response.setHeader("Access-Control-Max-Age", "3600");
                response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me, authorization, x-auth-token");
            }
        }



                if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
                    response.setStatus(HttpServletResponse.SC_OK);
                } else {
                    filterChain.doFilter(request, response);
                }

    }

}
