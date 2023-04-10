package com.example.them_san_pham_vao_gio_hang.service;

import com.example.them_san_pham_vao_gio_hang.entity.Cart;

import java.util.List;

public interface CartService {
    List<Cart> findAll();
    void delete(Integer id);
    void save(Cart cart);
    Cart findById(Integer id);
}
