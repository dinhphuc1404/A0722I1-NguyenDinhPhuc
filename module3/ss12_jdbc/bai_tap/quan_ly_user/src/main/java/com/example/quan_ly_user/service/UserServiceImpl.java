package com.example.quan_ly_user.service;

import com.example.quan_ly_user.model.User;
import com.example.quan_ly_user.reponsitory.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements IUserService{
    UserRepositoryImpl userRepository = new UserRepositoryImpl();
    @Override
    public void addNewUser(User user) {
        userRepository.addNewUser(user);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAllUser();
    }

    @Override
    public boolean deleteUser(int id) {
        return  userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userRepository.updateUser(user);
    }
    public List<User> sort(){
        return userRepository.sort();
    }
}
