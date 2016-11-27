package com.korgutlova.dao.impl;

import com.korgutlova.dao.RequestDao;
import com.korgutlova.entities.Request;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequestDaoImpl extends DAO implements RequestDao{
    @Override
    public boolean createRequest(Request request) {
        try {
            PreparedStatement statement;
            if(request.getVolunteerId() == 0) {
                statement= connection.prepareStatement("INSERT INTO request(needy_id, address, " +
                        "latitude, longitude, created_at, service_type, status) VALUES (?,?,?,?,?,?,?)");
                statement.setLong(1, request.getNeedyId());
                statement.setString(2, request.getAddress());
                statement.setDouble(3, request.getLatitude());
                statement.setDouble(4, request.getLongitude());
                statement.setTimestamp(5, request.getCreatedAt());
                statement.setString(6, request.getServiceType());
                statement.setString(7, request.getStatus());
            } else {
                statement = connection.prepareStatement("INSERT INTO request(needy_id, volunteer_id, address, " +
                        "latitude, longitude, created_at, service_type, status) VALUES (?,?,?,?,?,?,?,?)");
                statement.setLong(1, request.getNeedyId());
                statement.setLong(2, request.getVolunteerId());
                statement.setString(3, request.getAddress());
                statement.setDouble(4, request.getLatitude());
                statement.setDouble(5, request.getLongitude());
                statement.setTimestamp(6, request.getCreatedAt());
                statement.setString(7, request.getServiceType());
                statement.setString(8, request.getStatus());
            }
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
