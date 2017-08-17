package com.osoleksandr.dao;

public interface GenericDao<T> {
    void create(T t);
    void delete(T t);
    void update(T t);
    T get(T t);
}
