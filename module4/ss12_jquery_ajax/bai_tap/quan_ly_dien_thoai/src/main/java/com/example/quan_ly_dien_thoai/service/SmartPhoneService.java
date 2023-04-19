package com.example.quan_ly_dien_thoai.service;

import com.example.quan_ly_dien_thoai.model.SmartPhone;

import java.util.List;

public interface SmartPhoneService {
    List<SmartPhone> findAll();
    SmartPhone findById(Integer id);
    SmartPhone save(SmartPhone phone);
    SmartPhone remove(Integer id);
}
