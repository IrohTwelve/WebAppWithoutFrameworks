package com.osoleksandr.service;

import com.osoleksandr.dao.ProductDao;
import com.osoleksandr.model.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll(Integer id) {
        return null;
    }

    @Override
    public Product getProduct(Integer categoryId, Integer productId) {
        return null;
    }

    @Override
    public void create(String name, String discription, String categoryName) {

    }

    @Override
    public void delete(String product) {

    }
}
