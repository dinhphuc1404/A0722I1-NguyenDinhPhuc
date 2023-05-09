package com.example.final_exam.service;

import com.example.final_exam.entity.DoanhNghiep;
import com.example.final_exam.repository.DoanhNghiepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoanhNghiepServiceImpl implements DoanhNghiepService{
    @Autowired
    private DoanhNghiepRepository doanhNghiepRepository;
    @Override
    public void create(DoanhNghiep doanhNghiep) {
        doanhNghiepRepository.save(doanhNghiep);
    }

    @Override
    public void update(DoanhNghiep doanhNghiep) {
        doanhNghiepRepository.save(doanhNghiep);
    }

    @Override
    public void delete(Integer id) {
        doanhNghiepRepository.deleteById(id);
    }

    @Override
    public List<DoanhNghiep> findAll() {
        return doanhNghiepRepository.findAll();
    }

    @Override
    public DoanhNghiep findById(Integer id) {
        return doanhNghiepRepository.findById(id).orElse(null);
    }
}
