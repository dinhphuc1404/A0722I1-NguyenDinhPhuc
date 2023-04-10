package com.example.buc_anh_cua_ngay.service;

import com.example.buc_anh_cua_ngay.entity.Evaluate;
import com.example.buc_anh_cua_ngay.repository.EvaluateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EvaluateServiceImpl implements EvaluateService{
    @Autowired
    EvaluateRepository evaluateRepository;
    @Override
    public void addEvaluate(Evaluate evaluate) {
        evaluateRepository.save(evaluate);
    }

    @Override
    public List<Evaluate> getAll() {
        return evaluateRepository.findAll();
    }

    @Override
    public Page<Evaluate> findAllWithPaging(Pageable pageable) {
        return evaluateRepository.findAll(pageable);
    }

    @Override
    public Evaluate findById(int id) {
        return evaluateRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Evaluate evaluate) {
        evaluateRepository.save(evaluate);
    }
}
