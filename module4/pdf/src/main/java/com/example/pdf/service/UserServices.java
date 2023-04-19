package com.example.pdf.service;

import com.example.pdf.entity.User;
import com.example.pdf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServices {
    @Autowired
    private UserRepository repo;

    public List<User> listAll() {
        return repo.findAll();
    }
}
