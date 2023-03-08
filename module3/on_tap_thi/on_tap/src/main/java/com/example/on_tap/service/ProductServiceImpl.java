package com.example.on_tap.service;

import com.example.on_tap.model.Product;
import com.example.on_tap.repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements IProductService{
    ProductRepositoryImpl repository = new ProductRepositoryImpl();
    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean deleteProduct(int id) {
        return repository.deleteProduct(id);
    }

    @Override
    public void add(Product product) {
        repository.add(product);
    }

    @Override
    public boolean update(Product product) {
        return repository.update(product);
    }


    @Override
    public Product findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> search(String name) {
        return repository.search(name);
    }

    @Override
    public List<Product> sort() {
        return repository.sort();
    }
}
