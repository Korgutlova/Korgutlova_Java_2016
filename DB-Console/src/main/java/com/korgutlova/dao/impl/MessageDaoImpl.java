package com.korgutlova.dao.impl;

import com.korgutlova.dao.MessageDao;
import com.korgutlova.entities.Message;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDaoImpl extends DAO implements MessageDao {
    private final String query = "INSERT INTO message(text, sender_id, recipient_id, " +
            "created_at, status) VALUES (?,?,?,?,?)";

    @Override
    public boolean createMessage(Message message) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, message.getText());
            statement.setLong(2, message.getSenderId());
            statement.setLong(3, message.getRecipientId());
            statement.setTimestamp(4, message.getCreatedAt());
            statement.setString(5, message.getStatus());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
