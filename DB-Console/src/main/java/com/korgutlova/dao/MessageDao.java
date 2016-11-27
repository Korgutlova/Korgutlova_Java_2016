package com.korgutlova.dao;

import com.korgutlova.entities.Message;

public interface MessageDao {
    boolean createMessage(Message message);
}
