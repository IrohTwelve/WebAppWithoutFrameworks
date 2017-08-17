package com.osoleksandr.factory;

import com.osoleksandr.controller.GetAllCategoriesController;
import com.osoleksandr.controller.UserController;
import com.osoleksandr.dao.CategoryDao;
import com.osoleksandr.dao.CategoryDaoImpl;
import com.osoleksandr.dao.UserDaoImpl;
import com.osoleksandr.service.CategoryService;
import com.osoleksandr.service.CategoryServiceImpl;
import com.osoleksandr.service.UserService;
import com.osoleksandr.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;

public class Factory {

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

    public static UserController getUserController() {
        return new UserController(Factory.getUserService());
    }

    private static UserService getUserService() {
        return new UserServiceImpl(Factory.getUserDao());
    }

    public static UserDaoImpl getUserDao() {
        return new UserDaoImpl(Factory.getConnection());
    }

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
}
