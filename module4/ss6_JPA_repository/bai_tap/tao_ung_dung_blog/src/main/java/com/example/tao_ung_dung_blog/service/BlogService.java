package com.example.tao_ung_dung_blog.service;

import com.example.tao_ung_dung_blog.entity.Blog;

import java.util.List;

public interface BlogService {
    Blog getBlogById(int id);
    List<Blog> getList();
    List<Blog> getListWithPaging(int pageNumber, int pageRecords);
    void save(Blog blog);
    void update(Blog blog);
    void deleteBlogById(int id);
}
