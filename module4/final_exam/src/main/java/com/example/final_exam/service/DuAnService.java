package com.example.final_exam.service;

import com.example.final_exam.entity.DuAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface DuAnService {
    void create(DuAn duAn);
    void update(DuAn duAn);
    void delete(String id);
    List<DuAn> findAll();
    DuAn findById(String id);
    Page<DuAn> findAllWithPaging(Pageable pageable);
    Slice<DuAn> findAllWithSlice(Pageable pageable);
    List<DuAn> findAllByIdAndName(String id, String name, Pageable pageable);
    void deleteAll(String[] ids);
    Slice<DuAn> findAllBySearchAll(String id, String name,  Pageable pageable);
}
