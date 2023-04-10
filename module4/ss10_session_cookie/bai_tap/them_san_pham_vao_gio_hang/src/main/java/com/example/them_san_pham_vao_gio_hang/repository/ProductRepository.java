package com.example.them_san_pham_vao_gio_hang.repository;

import com.example.them_san_pham_vao_gio_hang.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
