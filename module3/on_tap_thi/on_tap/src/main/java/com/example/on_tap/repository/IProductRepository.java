package com.example.on_tap.repository;

import com.example.on_tap.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    boolean deleteProduct(int id);
    void add(Product product);
    boolean update(Product product);
    Product findById(int id);
    List<Product> search(String name);
    List<Product> sort();
}
