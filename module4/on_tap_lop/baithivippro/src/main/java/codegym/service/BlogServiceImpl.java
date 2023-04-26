package codegym.service;

import codegym.entity.Blog;
import codegym.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository repository;

    @Override
    public Page<Blog> getPageBlog(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void create(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void update(Blog blog) {
    repository.save(blog);
    }

    @Override
    public Blog findById(Long blogId) {
        return repository.findById(blogId).orElse(null);
    }

    @Override
    public void delete(Long blogId) {
        repository.deleteById(blogId);
    }

    @Override
    public Page<Blog> searchAllPage(String name, Pageable pageable) {
        return repository.findAllByBlogNameContaining(name,pageable);
    }

    @Override
    public List<Blog> findAll() {
        Iterable<Blog> iterable = repository.findAll();
        List<Blog> blogList = new ArrayList<>();
        for (Blog c : iterable) {
            blogList.add(c);
        }
        return blogList;
    }
}
