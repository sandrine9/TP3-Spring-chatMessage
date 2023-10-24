package com.bnpp.epita.MQ.application;

import com.bnpp.epita.MQ.domaine.ChatMessage;
import com.bnpp.epita.MQ.infrastructure.IChatMessageRepository;
import com.bnpp.epita.MQ.message.MonMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageServiceImpl implements IChatMessageService {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    ObjectMapper mapper;

    //couche repo
    @Autowired
    IChatMessageRepository repo;

    @Override
    public void sendMessage(ChatMessage chatMessage) {
        try {
            String msg = mapper.writeValueAsString(chatMessage);
            jmsTemplate.send("queue_EPITA", new MonMessage(msg));
            //save en BDD
            repo.save(chatMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        //jmsTemplate.send("queue_EPITA", new MonMessage(chatMessage.getContent()));

        // pour tranformer le msg envoyé String en objet
        //ChatMessage cMessage = mapper.readValue(message, ChatMessage.class);


    }

    @JmsListener(destination = "queue_EPITA")
    @Override
    public void receive(String message) {
        System.out.println("AppliConsumer : " + message);
        //save
        //ChatMessage cMessage = mapper.readValue(message, ChatMessage.class);
    }



}
