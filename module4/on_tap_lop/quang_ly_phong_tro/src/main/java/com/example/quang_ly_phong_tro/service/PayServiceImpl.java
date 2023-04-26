package com.example.quang_ly_phong_tro.service;

import com.example.quang_ly_phong_tro.entity.Pay;
import com.example.quang_ly_phong_tro.repository.PayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PayServiceImpl implements PayService{
    @Autowired
    PayRepository payRepository;
    @Override
    public void create(Pay pay) {
        payRepository.save(pay);
    }

    @Override
    public void update(Pay pay) {
        payRepository.save(pay);
    }

    @Override
    public void delete(Integer id) {
        payRepository.deleteById(id);
    }

    @Override
    public List<Pay> findAll() {
        return payRepository.findAll();
    }

    @Override
    public Pay findById(Integer id) {
        return payRepository.findById(id).orElse(null);
    }
}
