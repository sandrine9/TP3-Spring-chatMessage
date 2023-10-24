package com.bnpp.epita.MQ.message;

import com.bnpp.epita.MQ.domaine.ChatMessage;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

public class MonMessage implements MessageCreator {

    private String strMessage;

    public MonMessage(String strMessage) {
        this.strMessage = strMessage;
    }

    @Override
    public Message createMessage(Session session) throws JMSException{
        TextMessage tm = session.createTextMessage(strMessage);
        //ObjectMessage om = session.createObjectMessage(chatMessage);
        return tm;
    }
}
