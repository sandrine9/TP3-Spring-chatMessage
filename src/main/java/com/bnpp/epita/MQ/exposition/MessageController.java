package com.bnpp.epita.MQ.exposition;

import com.bnpp.epita.MQ.application.IChatMessageService;
import com.bnpp.epita.MQ.domaine.ChatMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    @Autowired
    IChatMessageService chatMessageService;

    //Sandrine
    ChatMessage chatMessage;

    @Autowired
    ObjectMapper mapper;
    @PostMapping("/send")
    public void sendMessage(@RequestBody DtoChatMessage dtoChatMessage){
        //convertir l'objet en json pour pouvoir l'envoyer comme une String
        //String json = mapper.writeValueAsString(dtoChatMessage);
        //chatMessageProducer.sendMessage((json));

        //Sandrine
        chatMessage = DtoConverter.convertToEntity(dtoChatMessage);
        chatMessageService.sendMessage(chatMessage);
    }
}
