package com.korgutlova.dao;

import com.korgutlova.entities.User;

import java.util.List;

public interface ReportsDao {
    int getNewsInCommunity(long id);

    List<User> getUsersWithTheMostMessages(int ... months);

    List<User> getRespondedUsersWithTheMostRequests(String pattern);
}
