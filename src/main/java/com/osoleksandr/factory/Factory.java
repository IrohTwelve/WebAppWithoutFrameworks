package com.osoleksandr.factory;

import com.osoleksandr.controller.*;
import com.osoleksandr.dao.CategoryDao;
import com.osoleksandr.dao.CategoryDaoImpl;
import com.osoleksandr.dao.UserDaoImpl;
import com.osoleksandr.service.CategoryService;
import com.osoleksandr.service.CategoryServiceImpl;
import com.osoleksandr.service.UserService;
import com.osoleksandr.service.UserServiceImpl;
import com.osoleksandr.servlet.ViewModel;

import java.sql.Connection;
import java.sql.DriverManager;

public class Factory {

    private static ViewModel vm = new ViewModel();
    private static Controller userNotFoundController;

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    //User
    public static GetUserController getUserController() {
        return new GetUserController(Factory.getUserService(), Factory.getCategoriesService());
    }

    private static UserService getUserService() {
        return new UserServiceImpl(Factory.getUserDao());
    }

    public static UserDaoImpl getUserDao() {
        return new UserDaoImpl(Factory.getConnection());
    }

    //Categories
    public static CategoryService getCategoriesService() {
        return new CategoryServiceImpl(Factory.getCategoryDAO());
    }

    public static CategoryDao getCategoryDAO() {
        return new CategoryDaoImpl(Factory.getConnection());
    }

    private static CategoryDao getCategoryDao() {
        return new CategoryDaoImpl(getConnection());
    }

    private static CategoryService getCategoryService() {
        return new CategoryServiceImpl(Factory.getCategoryDao());
    }

    public static GetAllCategoriesController getAllCategoriesController() {
        return new GetAllCategoriesController(Factory.getCategoryService());
    }

    //views
    public static ViewModel getViewModel() {
        return vm;
    }

    public static Controller getHomeController() {
        return new HomePageController();
    }

    public static Controller getLoginController() {
        return new LoginPageController();
    }

    public static Controller getProfileController() {
        return new ProfilePageController();
    }

    public static Controller getRegistrationController() {
        return new RegistrationPageController();
    }

    public static CreateUserController getCreateUserController() {
        return new CreateUserController(Factory.getUserService(), Factory.getCategoriesService());
    }

    public static Controller getUserNotFoundController() {
        return new UserNotFoundPageController();
    }
}
