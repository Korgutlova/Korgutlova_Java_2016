package com.korgutlova.dao;

import com.korgutlova.entities.User;

public interface UserDao {
    boolean createUser(User user);

    boolean existUser(long id);

    User getUser(long id);
}
