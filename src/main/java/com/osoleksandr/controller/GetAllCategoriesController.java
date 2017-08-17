package com.osoleksandr.controller;

import com.osoleksandr.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetAllCategoriesController {
    private CategoryService categoryService;

    public GetAllCategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", categoryService.getAll());
        request.getRequestDispatcher("/WEB-INF/views/categories.jsp").forward(request, response);
    }
}
