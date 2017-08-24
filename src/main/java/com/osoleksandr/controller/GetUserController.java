package com.osoleksandr.controller;

import com.osoleksandr.factory.Factory;
import com.osoleksandr.model.Roles;
import com.osoleksandr.model.User;
import com.osoleksandr.service.CategoryService;
import com.osoleksandr.service.UserService;
import com.osoleksandr.servlet.Request;
import com.osoleksandr.servlet.ViewModel;

import javax.servlet.http.Cookie;

public class GetUserController implements Controller {

    private UserService userService;
    private CategoryService categoryService;

    public GetUserController(UserService userService, CategoryService categoryService) {
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request request) {
        ViewModel vm = Factory.getViewModel();
        String userName = (String) vm.getAttribute("userName");
        String pass = (String) vm.getAttribute("password");
        User user = userService.findUser(userName, pass);
        if (user != null) {
            vm.setAttribute("user", user);
            vm.setCookie(new Cookie("token", user.getToken()));
            if (user.getRoles().contains(Roles.ADMIN)) {
                vm.setView("admin");
            } else {
                vm.setView("profile");
//                vm.setView("categories");
//                vm.setAttribute("categories", categoryService.getAll());
            }
        } else {
            vm.setView("userNotFound");
//            vm.setView("login");

        }
        return vm;
    }
}
