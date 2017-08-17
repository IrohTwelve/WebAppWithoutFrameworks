package com.osoleksandr.service;

import com.osoleksandr.dao.UserDao;
import com.osoleksandr.model.User;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(User user) {
        return userDao.getUser(user);
    }

    @Override
    public User findUser(String name, String password) {
        return userDao.findByName(name, password);
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }
}