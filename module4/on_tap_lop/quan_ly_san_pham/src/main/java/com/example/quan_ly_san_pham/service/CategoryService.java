package com.example.quan_ly_san_pham.service;

import com.example.quan_ly_san_pham.entity.Category;

import java.util.List;

public interface CategoryService {
    void create(Category category);
    void update(Category category);
    void delete(Integer id);
    List<Category> findAll();
    Category findById(Integer id);
}
