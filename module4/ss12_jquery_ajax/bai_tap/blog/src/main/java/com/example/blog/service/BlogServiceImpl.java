package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void remove(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public Page<Blog> searchByTitle(String c, Pageable p) {
        return blogRepository.searchByTitle(c,p);
    }

    @Override
    public List<Blog> searchByTitle(String c) {
        return blogRepository.searchByTitle(c);
    }

    @Override
    public Page<Blog> findBlogByCategory_Id(Integer id, Pageable p) {
        return blogRepository.findBlogByCategory_Id(id,p);
    }

    @Override
    public List<Blog> findAllByCategory_Id(Integer id) {
        return blogRepository.findAllByCategory_Id(id);
    }
}