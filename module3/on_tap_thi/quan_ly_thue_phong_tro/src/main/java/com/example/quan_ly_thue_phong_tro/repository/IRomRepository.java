package com.example.quan_ly_thue_phong_tro.repository;

import com.example.quan_ly_thue_phong_tro.model.Room;

import java.util.List;

public interface IRomRepository {
    List<Room> findAll();
    boolean delete(int id);
    void add(Room room);
    boolean update(Room room);
    Room findById(int id);
    List<Room> search(String name);
}
