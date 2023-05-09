package com.example.final_exam.service;

import com.example.final_exam.entity.DuAn;
import com.example.final_exam.repository.DuAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuAnServiceImpl implements DuAnService{
    @Autowired
    private DuAnRepository duAnRepository;
    @Override
    public void create(DuAn duAn) {
        duAnRepository.save(duAn);
    }

    @Override
    public void update(DuAn duAn) {
        duAnRepository.save(duAn);
    }

    @Override
    public void delete(String id) {
        duAnRepository.deleteById(id);
    }

    @Override
    public List<DuAn> findAll() {
        return duAnRepository.findAll();
    }

    @Override
    public DuAn findById(String id) {
        return duAnRepository.findById(id).orElse(null);
    }

    @Override
    public Page<DuAn> findAllWithPaging(Pageable pageable) {
        return duAnRepository.findAll(pageable);
    }

    @Override
    public Slice<DuAn> findAllWithSlice(Pageable pageable) {
        return duAnRepository.findAll(pageable);
    }

    @Override
    public List<DuAn> findAllByIdAndName(String id, String name, Pageable pageable) {
        return null;
    }

    @Override
    public void deleteAll(String[] ids) {

    }

    @Override
    public Slice<DuAn> findAllBySearchAll(String id, String name, Pageable pageable) {
        return null;
    }
}
