package com.osoleksandr.controller;

import com.osoleksandr.model.User;
import com.osoleksandr.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserController {

    private UserService userService;

    public CreateUserController(UserService userService) {
        this.userService = userService;
    }

    public void process(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        String token = username + System.nanoTime();
        User user = new User(username, password, token, email);
        userService.create(user);
        response.addCookie(new Cookie("TOKEN", token));
        request.getSession().invalidate();
    }
}
