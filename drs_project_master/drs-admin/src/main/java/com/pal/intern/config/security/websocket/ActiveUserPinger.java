package com.pal.intern.config.security.websocket;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

public class ActiveUserPinger {

    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private ActiveUserService activeUserService;

    @Scheduled(fixedDelay = 2000)
    public void pingUsers() {
        Set<String> activeUsers = activeUserService.getActiveUsers();
        template.convertAndSend("/topic/active", activeUsers);
    }
}
