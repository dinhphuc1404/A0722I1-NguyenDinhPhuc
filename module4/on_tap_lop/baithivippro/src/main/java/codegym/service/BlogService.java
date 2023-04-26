package codegym.service;

import codegym.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> getPageBlog(Pageable pageable);
    void create(Blog blog);
    void update(Blog blog);
    Blog findById(Long blogId);
    void delete(Long blogId);
    Page<Blog> searchAllPage(String name,Pageable pageable);

    List<Blog> findAll();

}
