package com.example.upload.service;

import com.example.upload.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    Blog findById(Long id);
    void save(Blog blog);
    void remove(Long id);
    List<Blog> findByContent(String content);
    List<Blog> findByCategory_Id(Long id);
}
