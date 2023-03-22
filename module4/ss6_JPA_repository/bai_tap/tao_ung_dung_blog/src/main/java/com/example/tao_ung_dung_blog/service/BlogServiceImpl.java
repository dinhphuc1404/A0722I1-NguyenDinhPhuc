package com.example.tao_ung_dung_blog.service;

import com.example.tao_ung_dung_blog.entity.Blog;
import com.example.tao_ung_dung_blog.repository.BlogRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogRepositories blogRepositories;
    @Override
    public Blog getBlogById(int id) {
        return blogRepositories.getBlogById(id);
    }

    @Override
    public List<Blog> getList() {
        return blogRepositories.getList();
    }

    @Override
    public List<Blog> getListWithPaging(int pageNumber, int pageRecords) {
        return blogRepositories.getListWithPaging(pageNumber,pageRecords);
    }

    @Override
    public void save(Blog blog) {
        blogRepositories.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepositories.update(blog);
    }

    @Override
    public void deleteBlogById(int id) {
        blogRepositories.deleteBlogById(id);
    }
}
