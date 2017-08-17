package com.osoleksandr.service;

import com.osoleksandr.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll(Integer id);
    Product getProduct(Integer categoryId, Integer productId);
    void create(String name, String discription, String categoryName);
    void delete(String product);
}
