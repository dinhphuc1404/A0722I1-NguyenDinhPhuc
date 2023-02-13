package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository{
    private static List<Product> productList;
    static {
        productList = new ArrayList<>();
        productList.add(new Product(1,"Phuc",25000));
    }

    @Override
    public List<Product> showAll() {
        return productList;
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
