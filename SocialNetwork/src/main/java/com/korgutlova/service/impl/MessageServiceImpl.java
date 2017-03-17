package com.korgutlova.service.impl;

import com.korgutlova.model.Chat;
import com.korgutlova.model.Message;
import com.korgutlova.repository.MessageRepository;
import com.korgutlova.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService{

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getMessages(Chat chat) {
        return messageRepository.findMessagesByChat(chat);
    }

    @Override
    public void addMessage(Message message) {
        messageRepository.save(message);
    }
}
