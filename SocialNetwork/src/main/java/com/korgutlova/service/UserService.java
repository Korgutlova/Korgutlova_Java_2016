package com.korgutlova.service;

import com.korgutlova.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> getAll();

    User getUser(Long id);
}
