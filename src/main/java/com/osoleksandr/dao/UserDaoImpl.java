package com.osoleksandr.dao;

import com.osoleksandr.model.Roles;
import com.osoleksandr.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public User getUser(User user) {
       return user;
    }

    @Override
    public User findByName(String name, String password) {
        User user = null;
        Integer id = null;
        String email = null;
        String token = null;
        Set<Roles> roles = new HashSet<Roles>();
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "SELECT  U.ID, U.USERNAME, U.PASSWORD, U.TOKEN, U.EMAIL, R.ROLENAME " +
                    "FROM USERS U " +
                    "JOIN USERTOROLE UR ON UR.USERID=U.ID " +
                    "JOIN ROLES R ON R.ID = UR.ROLEID " +
                    "WHERE U.USERNAME = ? " +
                    "AND U.PASSWORD = ?";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                email = rs.getString("EMAIL");
                token = rs.getString("TOKEN");
                roles.add(Roles.valueOf(rs.getString("ROLENAME")));
            }
            preparedStatement.close();
            user = new User(id, name, password, email, token, roles);
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
        return user;
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
            throw new RuntimeException("UserDaoImpl \"create\" method" + e);
        }
    }

    @Override
    public User findByToken(String token) {
        return null;
    }
}
