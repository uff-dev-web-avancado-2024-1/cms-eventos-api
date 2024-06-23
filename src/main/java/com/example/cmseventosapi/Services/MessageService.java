package com.example.cmseventosapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cmseventosapi.Model.Message;
import com.example.cmseventosapi.Repositories.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository repository;

    public Message CreateMessage(Message message) {
        return this.repository.save(message);
    }

    public Message UpdateMessage(Message message, Long id) {
        Message messageToUpdate = this.repository.findById(id).get();
        messageToUpdate.setContent(message.getContent());
        messageToUpdate.setSender(message.getSender());
        messageToUpdate.setReceiver(message.getReceiver());
        return this.repository.save(message);
    }

    public Message GetMessage(Long id) {
        return this.repository.findById(id).get();
    }
}
