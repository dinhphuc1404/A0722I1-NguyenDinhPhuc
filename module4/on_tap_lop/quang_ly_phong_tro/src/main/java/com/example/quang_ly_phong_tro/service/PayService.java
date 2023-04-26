package com.example.quang_ly_phong_tro.service;

import com.example.quang_ly_phong_tro.entity.Pay;

import java.util.List;

public interface PayService {
    void create(Pay pay);
    void update(Pay pay);
    void delete(Integer id);
    List<Pay> findAll();
    Pay findById(Integer id);
}
