package com.osoleksandr.servlet;

import com.osoleksandr.controller.GetAllCategoriesController;
import com.osoleksandr.controller.UserController;
import com.osoleksandr.factory.Factory;
import com.osoleksandr.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    private UserController userController;
    private CategoryService categoryService;
    private GetAllCategoriesController getAllCategoriesController;

    public void init() {
        userController = Factory.getUserController();
        getAllCategoriesController = Factory.getAllCategoriesController();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equals("GET") && request.getRequestURI().equals("/root/home")) {
            request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        }

        if (request.getMethod().equals("GET") && request.getRequestURI().equals("/root/login")) {
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }

        if (request.getMethod().equals("POST") && request.getRequestURI().equals("/root/login")) {
            userController.getUser(request, response);
        }
        if(request.getMethod().equals("GET") && request.getRequestURI().equals("/root/categories")) {
            getAllCategoriesController.process(request, response);
        }
    }
}
