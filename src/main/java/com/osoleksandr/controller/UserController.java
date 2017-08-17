package com.osoleksandr.controller;

import com.osoleksandr.model.User;
import com.osoleksandr.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = new User(userName, password);
        if (userService.getUser(user) != null) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
        } else {
            throw new RuntimeException("User " + user + " does not exist");
        }
        return user;
    }
}
