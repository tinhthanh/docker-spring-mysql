package com.pal.intern.services;
import com.pal.intern.config.security.websocket.ActiveUserService;
import com.pal.intern.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
@Service
public class NotifyServiceImpl implements NotifyService{
  @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private ActiveUserService activeUserService;
    @Override
    public void sendNotifyToUser(ChatMessage chatMessage) {
          template.convertAndSend("/listen-change-res/change", chatMessage);
    }
}
