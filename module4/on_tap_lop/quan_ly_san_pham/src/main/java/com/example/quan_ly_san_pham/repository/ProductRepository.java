package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.entity.Product;
import org.hibernate.sql.Select;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    void deleteAllByIdIn(String[] ids);
    Slice<Product> findAllByIdContainsOrNameContains(String id, String name, Pageable pageable);
    List<Product> findAllByIdContainingAndNameContaining(String id, String name, Pageable pageable);

//    @Query("Select p from Product p where p.id like %:id% or p.name like %:price%" )
//    Slice<Product> findByHQL(@Param("id") String id, @Param("price") Double price, Pageable pageable);
}
