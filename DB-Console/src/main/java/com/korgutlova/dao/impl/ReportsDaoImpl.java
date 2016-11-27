package com.korgutlova.dao.impl;

import com.korgutlova.dao.ReportsDao;
import com.korgutlova.dao.UserDao;
import com.korgutlova.entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportsDaoImpl extends DAO implements ReportsDao {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public int getNewsInCommunity(long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT count(*) " +
                    "FROM community JOIN news ON community.id = news.community_id " +
                    "WHERE founder_id = ? GROUP BY news.id");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            int sum = 0;
            while (resultSet.next()) {
                sum += 1;
            }
            return sum;
        } catch (SQLException e) {
            System.out.println("Error");
            return 0;
        }
    }

    @Override
    public List<User> getUsersWithTheMostMessages(int... months) {
        try {
            PreparedStatement statement = connection.prepareStatement("WITH user_msg AS (\n" +
                    "    SELECT\n" +
                    "      u.id,\n" +
                    "      count(m_r.id) msg_rec\n" +
                    "    FROM users u\n" +
                    "      LEFT JOIN message m_r ON u.id = m_r.recipient_id\n" +
                    "    WHERE extract(MONTH FROM m_r.created_at) IN (?, ?, ?)\n" +
                    "    GROUP BY u.id\n" +
                    ")\n" +
                    "SELECT\n" +
                    "  user_msg.id\n" +
                    "FROM user_msg\n" +
                    "WHERE user_msg.msg_rec = (SELECT max(user_msg.msg_rec)\n" +
                    "                                  FROM user_msg)");
            statement.setInt(1, months[0]);
            statement.setInt(2, months[1]);
            statement.setInt(3, months[2]);
            ResultSet resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(userDao.getUser(resultSet.getLong("id")));
            }
            return users;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<User> getRespondedUsersWithTheMostRequests(String pattern) {
        try {
            PreparedStatement statement = connection.prepareStatement("WITH users_vol AS (\n" +
                    "    SELECT\n" +
                    "      users.id,\n" +
                    "      count(*) resp\n" +
                    "    FROM users\n" +
                    "      JOIN request ON users.id = request.volunteer_id\n" +
                    "    WHERE request.address LIKE ?\n" +
                    "    GROUP BY users.id\n" +
                    ")\n" +
                    "SELECT users_vol.id\n" +
                    "FROM users_vol\n" +
                    "WHERE resp = (SELECT max(users_vol.resp)\n" +
                    "              FROM users_vol)");
            statement.setString(1, '%' + pattern + '%');
            ResultSet resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(userDao.getUser(resultSet.getLong("id")));
            }
            return users;
        } catch (SQLException e) {
            return null;
        }
    }
}
