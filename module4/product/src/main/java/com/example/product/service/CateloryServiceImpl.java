package com.example.product.service;

import com.example.product.entity.Catelogy;
import com.example.product.repository.CateloryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateloryServiceImpl implements CatelogyService {

    @Autowired
    private CateloryRepository cateloryRepository;
    @Override
    public List<Catelogy> findAll() {
        return cateloryRepository.findAll();
    }
}
