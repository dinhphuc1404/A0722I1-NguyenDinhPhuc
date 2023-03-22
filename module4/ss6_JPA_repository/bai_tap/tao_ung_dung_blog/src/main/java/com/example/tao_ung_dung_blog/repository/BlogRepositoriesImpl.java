package com.example.tao_ung_dung_blog.repository;

import com.example.tao_ung_dung_blog.entity.Blog;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class BlogRepositoriesImpl implements BlogRepositories {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Blog getBlogById(int id) {
        return entityManager.find(Blog.class,id);
    }

    @Override
    public List<Blog> getList() {
        return entityManager.createQuery("select b from Blog b").getResultList();
    }

     /*
        pageNumber: số trang
        pageRecords: số record mỗi trang
     */

    @Override
    public List<Blog> getListWithPaging(int pageNumber, int pageRecords) {
        return entityManager.createQuery("select b from Blog b")
                .setFirstResult((pageNumber - 1) * pageRecords)
                .setMaxResults(pageRecords)
                .getResultList();
    }

    @Override
    public void save(Blog blog) {
        entityManager.persist(blog);
    }

    @Override
    public void update(Blog blog) {
        entityManager.merge(blog);
    }

    @Override
    public void deleteBlogById(int id) {
        Blog blog = entityManager.find(Blog.class, id);
        entityManager.remove(blog);
    }
}
