package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.Category;

import java.util.List;

public interface CateloryService {
    void create(Category category);
    void update(Category category);
    void delete(String id);
    List<Category> findAll();
    Category findById(String id);
}
