package com.example.quan_ly_dien_thoai.service;

import com.example.quan_ly_dien_thoai.model.Category;
import com.example.quan_ly_dien_thoai.repository.CategoryRepositoryImpl;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService{
    CategoryRepositoryImpl categoryRepository = new CategoryRepositoryImpl();
    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAllCategory();
    }
}
