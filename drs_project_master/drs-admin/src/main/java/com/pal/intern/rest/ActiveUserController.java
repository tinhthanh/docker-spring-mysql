package com.pal.intern.rest;

import com.pal.intern.config.security.websocket.ActiveUserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ActiveUserController {

    @Autowired
    private ActiveUserService activeUserService;

    @MessageMapping("/activeUsers")
    public void activeUsers(Message<Object> message) {
        Principal user = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);
        if( user !=  null) {
          activeUserService.mark(user.getName());
        }
      
    }
}
