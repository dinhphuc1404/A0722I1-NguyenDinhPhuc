package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.model.Product;

import java.util.List;

public interface IProductRepository {
    public List<Product> showAll();
    public void addNew(Product product);
    public boolean uppdate(Product product);
    public boolean delete(int id);
    public Product findById(int id);
}
