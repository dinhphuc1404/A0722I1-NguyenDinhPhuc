package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
