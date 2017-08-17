package com.osoleksandr.dao;

import com.osoleksandr.model.Product;

import java.sql.Connection;
import java.util.List;

public class ProductDaoImpl extends AbstractDao<String> implements ProductDao {

    protected ProductDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public Product get(Product product) {
        return null;
    }

    @Override
    public List<Product> getAll(Integer categoryId) {
        return null;
    }

    @Override
    public Product getProduct(Integer categoryId, Integer productId) {
        return null;
    }

    @Override
    public void create(String name, String description, String categoryName) {

    }

    @Override
    public void delete(String product) {

    }
}
