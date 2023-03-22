package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.Category;
import com.example.ung_dung_blog.repository.CateloryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CateloryServiceImpl implements CateloryService{
    @Autowired
    CateloryRepository cateloryRepository;
    @Override
    public void create(Category category) {
        cateloryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        cateloryRepository.save(category);
    }

    @Override
    public void delete(String id) {
        cateloryRepository.deleteById(id);
    }

    @Override
    public List<Category> findAll() {
        return cateloryRepository.findAll();
    }

    @Override
    public Category findById(String id) {
        return cateloryRepository.findById(id).orElse(null);
    }
}
