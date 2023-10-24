package com.bnpp.epita.MQ.exposition;

import com.bnpp.epita.MQ.domaine.ChatMessage;

public class DtoConverter {

    public static ChatMessage convertToEntity (DtoChatMessage dto){
        ChatMessage msg = new ChatMessage();
        msg.setSender(dto.getSender());
        msg.setRecipient(dto.getRecipient());
        msg.setContent(dto.getContent());
        msg.setTimestamp(dto.getTimestamp());
        return msg;
    }
}
