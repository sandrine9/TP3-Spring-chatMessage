package com.bnpp.epita.MQ.application;

import com.bnpp.epita.MQ.domaine.ChatMessage;

public interface IChatMessageService {
    void sendMessage(ChatMessage chatMessage);
    void receive(String message);

}
