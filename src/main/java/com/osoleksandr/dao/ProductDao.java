package com.osoleksandr.dao;

import com.osoleksandr.model.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Product> {
    List<Product> getAll(Integer categoryId);
    Product getProduct(Integer categoryId, Integer productId);
    void create(String name, String description, String categoryName);
    void delete(String product);

}
