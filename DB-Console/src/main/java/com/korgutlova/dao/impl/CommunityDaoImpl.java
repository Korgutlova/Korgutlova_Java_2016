package com.korgutlova.dao.impl;

import com.korgutlova.dao.CommunityDao;
import com.korgutlova.entities.Community;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommunityDaoImpl extends DAO implements CommunityDao {

    @Override
    public Community getCommunity(long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM community WHERE id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Community(id, resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getLong("founder_id"),
                        resultSet.getDate("created_at"));
            }
            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean updateCommunity(Community community) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE community SET name=?, " +
                    "description=?, founder_id=?, created_at=? WHERE id=?");
            statement.setString(1, community.getName());
            statement.setString(2, community.getDescription());
            statement.setLong(3, community.getFounderId());
            statement.setDate(4, community.getCreatedAt());
            statement.setLong(5, community.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
