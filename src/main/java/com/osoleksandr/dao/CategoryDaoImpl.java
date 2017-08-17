package com.osoleksandr.dao;

import com.osoleksandr.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl extends AbstractDao<Category> implements CategoryDao {

    public CategoryDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Category> getAll() {
        List<Category> list = new ArrayList<Category>();
        Category category = null;
        Integer id = null;
        String name = null;
        String description = null;
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "SELECT * FROM CATEGORY";
            preparedStatement = connection.prepareStatement(preparedQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("NAME");
                description = rs.getString("DESCRIPTION");
                category = new Category(id, name, description);
                list.add(category);
            }
        } catch (SQLException e) {
            System.out.println("CategoryDaoImpl <getAll();>" + e );
        }
        return list;
    }
}
