package com.korgutlova.dao.impl;

import com.korgutlova.dao.UserDao;
import com.korgutlova.entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends DAO implements UserDao {
    private final String queryCreate = "INSERT INTO users(name, surname, email, " +
            "password, role, status) VALUES  (?,?,?,?,?,?)";
    private final String queryGet = "SELECT * FROM users where id=?";

    public boolean createUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(queryCreate);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getRole());
            statement.setString(6, user.getStatus());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean existUser(long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(queryGet);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public User getUser(long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(queryGet);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("role"),
                        resultSet.getString("status"));
            }
            return null;
        } catch (SQLException e) {
            return null;
        }
    }
}
