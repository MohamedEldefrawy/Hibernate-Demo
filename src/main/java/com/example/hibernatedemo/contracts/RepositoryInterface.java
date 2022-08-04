package com.example.hibernatedemo.contracts;

import java.util.List;

public interface RepositoryInterface<T> {
    public void create(T entity);

    public T get(int id);

    public List<T> get();

    public void update(int id, T entity);

    public void delete(int id);
}
