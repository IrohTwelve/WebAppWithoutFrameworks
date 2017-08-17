package com.osoleksandr.service;

import com.osoleksandr.model.User;

public interface UserService {
    User getUser(User user);
    User findUser(String name, String password);
    void create(User user);
}
