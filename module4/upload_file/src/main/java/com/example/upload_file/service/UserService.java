package com.example.upload_file.service;

import com.example.upload_file.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void create(User user);
    User findById(Integer id);
    void update(User user);
    void delete(Integer id);
}
