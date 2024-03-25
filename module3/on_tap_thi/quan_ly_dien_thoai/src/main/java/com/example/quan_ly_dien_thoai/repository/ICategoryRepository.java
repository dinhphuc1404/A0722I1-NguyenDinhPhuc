package com.example.quan_ly_dien_thoai.repository;

import com.example.quan_ly_dien_thoai.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAllCategory();
}
