package com.example.quan_ly_user.reponsitory;

import com.example.quan_ly_user.model.User;

import java.util.List;

public interface IUserRepository {
    public void addNewUser(User user);
    public User findById(int id);
    public List<User> findAllUser();
    public boolean deleteUser(int id);
    public boolean updateUser(User user);
}
