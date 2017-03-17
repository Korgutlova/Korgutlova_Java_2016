package com.korgutlova.service;

import com.korgutlova.model.Chat;
import com.korgutlova.model.Message;

import java.util.List;

public interface MessageService {

    List<Message> getMessages(Chat chat);

    void addMessage(Message message);
}
