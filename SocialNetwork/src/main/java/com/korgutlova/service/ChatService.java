package com.korgutlova.service;

import com.korgutlova.model.Chat;
import com.korgutlova.model.User;

import java.util.List;

public interface ChatService {
    List<Chat> getChats(User user);

    Chat getChat(Long id);

    int existsChat(User userOne, User userTwo);

    Chat getChat(User userOne, User userTwo);

    void addChat(Chat chat);
}
