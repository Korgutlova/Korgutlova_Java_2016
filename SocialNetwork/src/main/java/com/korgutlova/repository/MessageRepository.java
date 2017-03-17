package com.korgutlova.repository;

import com.korgutlova.model.Chat;
import com.korgutlova.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findMessagesByChat(Chat chat);
}
