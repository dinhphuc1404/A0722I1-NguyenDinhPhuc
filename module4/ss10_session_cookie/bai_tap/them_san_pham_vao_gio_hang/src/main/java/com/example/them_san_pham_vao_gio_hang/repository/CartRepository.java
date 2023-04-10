package com.example.them_san_pham_vao_gio_hang.repository;

import com.example.them_san_pham_vao_gio_hang.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
