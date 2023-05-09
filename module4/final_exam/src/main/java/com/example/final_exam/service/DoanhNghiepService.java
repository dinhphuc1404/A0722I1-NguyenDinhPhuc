package com.example.final_exam.service;

import com.example.final_exam.entity.DoanhNghiep;

import java.util.List;

public interface DoanhNghiepService {
    void create(DoanhNghiep doanhNghiep);
    void update(DoanhNghiep doanhNghiep);
    void delete(Integer id);
    List<DoanhNghiep> findAll();
    DoanhNghiep findById(Integer id);
}
