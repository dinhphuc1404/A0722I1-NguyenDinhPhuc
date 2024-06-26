package com.example.student.service;

import com.example.student.entity.ClassName;
import com.example.student.repository.ClassNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassNameServiceImpl implements ClassNameService {
    @Autowired
    ClassNameRepository repository;

    @Override
    public void create(ClassName className) {
        repository.save(className);
    }

    @Override
    public void update(ClassName className) {
        repository.save(className);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<ClassName> findAll() {
        return repository.findAll();
    }

    @Override
    public ClassName findById(String id) {
        return repository.findById(id).orElse(null);
    }
}
