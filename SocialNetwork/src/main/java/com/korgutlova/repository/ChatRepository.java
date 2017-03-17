package com.korgutlova.repository;

import com.korgutlova.model.Chat;
import com.korgutlova.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
