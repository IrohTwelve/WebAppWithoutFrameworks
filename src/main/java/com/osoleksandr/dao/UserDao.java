package com.osoleksandr.dao;

import com.osoleksandr.model.User;

public interface UserDao {
    User getUser(User user);

    User findByName(String name, String password);

    void create(User user);

    User findByToken(String token);

}
