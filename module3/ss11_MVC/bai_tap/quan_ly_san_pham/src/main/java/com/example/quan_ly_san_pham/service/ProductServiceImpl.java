package com.example.quan_ly_san_pham.service;

import com.example.quan_ly_san_pham.model.Product;

import java.util.List;

public class ProductServiceImpl implements IProductService{
    ProductServiceImpl productService = new ProductServiceImpl();
    @Override
    public List<Product> showAll() {
        return productService.showAll();
    }

    @Override
    public void addNew(Product product) {
        productService.addNew(product);
    }

    @Override
    public boolean uppdate(Product product) {
        return productService.uppdate(product);
    }

    @Override
    public boolean delete(int id) {
        return productService.delete(id);
    }

    @Override
    public Product findById(int id) {
        return productService.findById(id);
    }
}
