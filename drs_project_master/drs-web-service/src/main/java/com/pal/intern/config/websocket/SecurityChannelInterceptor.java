package com.pal.intern.config.websocket;
import com.pal.intern.config.jwt.JwtService;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
public class SecurityChannelInterceptor extends ChannelInterceptorAdapter{
        private static final Logger logger = LoggerFactory.getLogger(SecurityChannelInterceptor.class);
    @Autowired
     JwtService jwtService;
       @Autowired
     UserDetailsService userDetailsService;
       @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {                             
                StompHeaderAccessor accessor =
                        MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
                if (StompCommand.CONNECT.equals(accessor.getCommand())) {
                     String userName = null;
                     List<String> token =  accessor.getNativeHeader("Authorization");
                        if ( token!= null && token.size() == 1 ) {
                             try {
                                 userName = this.jwtService.getUserNameFromToKen(token.get(0));
                                 logger.info("User: " + userName + "connect ");
                       } catch (IllegalArgumentException e) {
                                    logger.error("an error occured during getting username from token", e);
                       } catch (ExpiredJwtException e) {
                            logger.error("the token is expired and not valid anymore", e);
                       }
                        } else {
                            logger.info("Fail token socket" + token);
                        }
                          if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                               UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
                                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                  userDetails, null, userDetails.getAuthorities());
                                SecurityContextHolder.getContext().setAuthentication(authentication);
                             accessor.setUser(authentication);
                          }
                }
                return message;
            }
}
