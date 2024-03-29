package com.example.mo_rong_ung_dung_blog.repository;

import com.example.mo_rong_ung_dung_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where header like %c% ",nativeQuery = true)
    Page<Blog> searchByCharacter(@Param("c") String c, Pageable p);
    Page<Blog> findBlogByCategory_Id(Integer id, Pageable p);

}
