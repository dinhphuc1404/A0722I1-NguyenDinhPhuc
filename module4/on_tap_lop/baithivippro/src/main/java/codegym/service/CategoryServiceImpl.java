package codegym.service;

import codegym.entity.Category;
import codegym.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        Iterable<Category> iterable = categoryRepository.findAll();
        List<Category> categoryList = new ArrayList<>();
        for (Category c : iterable) {
            categoryList.add(c);
        }
        return categoryList;
    }
}
