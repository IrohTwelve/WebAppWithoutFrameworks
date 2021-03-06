package com.osoleksandr.controller;

import com.osoleksandr.factory.Factory;
import com.osoleksandr.model.Roles;
import com.osoleksandr.model.User;
import com.osoleksandr.service.CategoryService;
import com.osoleksandr.service.UserService;
import com.osoleksandr.servlet.Request;
import com.osoleksandr.servlet.ViewModel;

import javax.servlet.http.Cookie;

public class CreateUserController implements Controller {

    private UserService userService;
    private CategoryService categoryService;

    public CreateUserController(UserService userService, CategoryService categoryService) {
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request request) {
        ViewModel vm = Factory.getViewModel();
        String userName = (String) vm.getAttribute("userName");
        String password = (String) vm.getAttribute("password");
        String email = (String) vm.getAttribute("email");
        String token = userName + System.nanoTime();
        User user = new User(null, userName, password, email, token, null);
        userService.create(user);
        vm.setAttribute("user", user);
        vm.setCookie(new Cookie("token", user.getToken()));
        if (user.getRoles().contains(Roles.ADMIN)) {
            vm.setView("admin");
        } else {
            vm.setView("categories");
            vm.setAttribute("categories", categoryService.getAll());
        }
        return vm;
    }
}
