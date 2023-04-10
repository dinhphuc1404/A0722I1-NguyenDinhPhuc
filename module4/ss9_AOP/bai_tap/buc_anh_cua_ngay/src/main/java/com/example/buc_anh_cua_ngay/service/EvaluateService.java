package com.example.buc_anh_cua_ngay.service;

import com.example.buc_anh_cua_ngay.entity.Evaluate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EvaluateService {
    void addEvaluate(Evaluate evaluate);
    List<Evaluate> getAll();
    Page<Evaluate> findAllWithPaging(Pageable pageable);
    Evaluate findById(int id);
    void update(Evaluate evaluate);
}
