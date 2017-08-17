package com.osoleksandr.dao;

import java.sql.Connection;

public class AbstractDao<T> {

    protected final Connection connection;

    protected AbstractDao(Connection connection) {
        this.connection = connection;
    }
}
