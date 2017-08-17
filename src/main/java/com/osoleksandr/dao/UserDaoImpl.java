package com.osoleksandr.dao;

import com.osoleksandr.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl extends AbstractDao implements UserDao {

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public User getUser(User user) {
       return user;
    }

    @Override
    public User findByName(String name, String password) {
        return null;
    }

    @Override
    public void create(User user) {
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "INSERT INTO USERS (USERNAME, TOKEN, PASSWORD, EMAIL) VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getToken());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("UserDaoImpl \"create\"" + e);
        }
    }

    @Override
    public User findByToken(String token) {
        return null;
    }
}
