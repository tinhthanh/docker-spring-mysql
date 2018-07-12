package com.pal.intern.rest;

import com.pal.intern.model.ChatMessage;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/chat")
    public void greeting(Message<Object> message, @Payload ChatMessage chatMessage) throws Exception {
        Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);
        String authedSender = principal.getName();
        chatMessage.setSender(authedSender);
        String recipient = chatMessage.getRecipient();
        if (!authedSender.equals(recipient)) {
            template.convertAndSendToUser(authedSender, "/queue/messages", chatMessage);
        }
        template.convertAndSendToUser(recipient, "/queue/messages", chatMessage);
    }
}
