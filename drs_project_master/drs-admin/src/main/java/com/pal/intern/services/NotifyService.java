package com.pal.intern.services;
import com.pal.intern.model.ChatMessage;
public interface NotifyService {
    public void sendNotifyToUser(ChatMessage chatMessage);
}
