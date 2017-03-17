package com.korgutlova.service.impl;

import com.korgutlova.model.Chat;
import com.korgutlova.model.User;
import com.korgutlova.repository.ChatRepository;
import com.korgutlova.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class ChatServiceImpl implements ChatService{

    private final ChatRepository chatRepository;
    private final String QUERY_GET_CHAT = "select distinct c from Chat c WHERE (c.userOne = :u and c.userTwo = :d)" +
            " or (c.userOne = :d and c.userTwo = :u)";

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public ChatServiceImpl(ChatRepository chatRepository, EntityManager entityManager) {
        this.chatRepository = chatRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<Chat> getChats(User user) {
        return entityManager.createQuery("select distinct c from Chat c WHERE c.userOne = :u or c.userTwo = :u", Chat.class)
                .setParameter("u", user).getResultList();
    }

    @Override
    public Chat getChat(Long id) {
        return chatRepository.findOne(id);
    }

    @Override
    public int existsChat(User userOne, User userTwo) {
        return entityManager.createQuery(QUERY_GET_CHAT, Chat.class)
                .setParameter("u", userOne).setParameter("d", userTwo).getResultList().size();
    }

    @Override
    public Chat getChat(User userOne, User userTwo) {
        return entityManager.createQuery(QUERY_GET_CHAT, Chat.class)
                .setParameter("u", userOne).setParameter("d", userTwo).getSingleResult();
    }

    @Override
    public void addChat(Chat chat) {
        chatRepository.save(chat);
    }
}
