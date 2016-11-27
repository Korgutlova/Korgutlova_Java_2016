package com.korgutlova.dao.impl;

import com.korgutlova.dao.NewsDao;
import com.korgutlova.entities.News;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsDaoImpl extends DAO implements NewsDao {

    @Override
    public News getNews(long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM news WHERE id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new News(id, resultSet.getString("text"),
                        resultSet.getLong("community_id"),
                        resultSet.getLong("author_id"),
                        resultSet.getTimestamp("created_at"));
            }
            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean updateNews(News news) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE news SET text=?, " +
                    "community_id=?, author_id=?, created_at=? WHERE id=?");
            statement.setString(1, news.getText());
            statement.setLong(2, news.getCommunityId());
            statement.setLong(3, news.getAuthorId());
            statement.setTimestamp(4, news.getCreatedAt());
            statement.setLong(5, news.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
