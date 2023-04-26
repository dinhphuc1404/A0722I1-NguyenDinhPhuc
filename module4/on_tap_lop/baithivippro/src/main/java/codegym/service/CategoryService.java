package codegym.service;

import codegym.entity.Category;

import java.util.List;

public interface CategoryService {
    Category findById(Long categoryId);
    List<Category> findAll();
}
