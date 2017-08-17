package com.osoleksandr.service;

import com.osoleksandr.dao.CategoryDao;
import com.osoleksandr.model.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }
}
