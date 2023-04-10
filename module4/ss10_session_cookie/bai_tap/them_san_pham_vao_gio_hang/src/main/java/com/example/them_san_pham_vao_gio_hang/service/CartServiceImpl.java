package com.example.them_san_pham_vao_gio_hang.service;

import com.example.them_san_pham_vao_gio_hang.entity.Cart;
import com.example.them_san_pham_vao_gio_hang.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartRepository cartRepository;
    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public Cart findById(Integer id) {
        return cartRepository.findById(id).orElse(null);
    }
}
