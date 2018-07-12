package com.pal.intern.model;

public class ChatMessage {

    private String recipient;
    private NotifyContent message;


    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    private String sender;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }


    public NotifyContent getMessage() {
        return message;
    }

    public void setMessage(NotifyContent message  ) {
        this.message = message;       
    }

    public ChatMessage(NotifyContent message  , String  recipient ) {
        this.message = message;     
        this.recipient =    recipient ;
        this.sender = message.getUserSend()  ;
    }

    
    public ChatMessage() {
    }
    

}
