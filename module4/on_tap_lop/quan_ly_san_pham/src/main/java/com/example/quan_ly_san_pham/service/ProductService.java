package com.example.quan_ly_san_pham.service;

import com.example.quan_ly_san_pham.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ProductService {
    void create(Product product);
    void update(Product product);
    void delete(String id);
    List<Product> findAll();
    Product findById(String id);
    Page<Product> findAllWithPaging(Pageable pageable);
     Slice<Product> findAllWithSlice(Pageable pageable);
    List<Product> findAllByIdAndName(String id, String name, Pageable pageable);
    void deleteAll(String[] ids);
    Slice<Product> findAllBySearchAll(String id, String name,  Pageable pageable);
}
