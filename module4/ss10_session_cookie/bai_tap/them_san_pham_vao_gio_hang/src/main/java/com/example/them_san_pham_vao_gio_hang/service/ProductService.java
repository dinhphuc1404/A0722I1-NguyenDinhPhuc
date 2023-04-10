package com.example.them_san_pham_vao_gio_hang.service;

import com.example.them_san_pham_vao_gio_hang.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void delete(Integer id);
    void save(Product product);
    Product findById(Integer id);

}
