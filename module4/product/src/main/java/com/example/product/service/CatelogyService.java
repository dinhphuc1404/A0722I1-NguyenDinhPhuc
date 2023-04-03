package com.example.product.service;

import com.example.product.entity.Catelogy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatelogyService {
    List<Catelogy>findAll();
}