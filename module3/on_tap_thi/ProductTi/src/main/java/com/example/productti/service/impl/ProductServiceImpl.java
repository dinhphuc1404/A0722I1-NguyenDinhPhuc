package com.example.productti.service.impl;

import com.example.productti.model.Product;
import com.example.productti.repository.impl.ProductRepositoryImpl;
import com.example.productti.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAllProduct();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}
