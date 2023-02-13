package com.example.ung_dung_quan_ly_san_pham.repository;

import com.example.ung_dung_quan_ly_san_pham.model.Product;

import java.util.List;

public class ProductRepositoryImpl implements IProductRepository{
    @Override
    public List<Product> showAll() {
        return null;
    }

    @Override
    public void addNew(Product product) {

    }

    @Override
    public boolean uppdate(Product product) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Product findById(int id) {
        return null;
    }
}
