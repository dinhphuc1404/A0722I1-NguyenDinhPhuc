package com.example.quan_ly_thue_phong_tro.repository;

import com.example.quan_ly_thue_phong_tro.model.Room;

import java.util.List;

public class RoomRepositoryImpl implements IRomRepository{
    @Override
    public List<Room> findAll() {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public void add(Room room) {

    }

    @Override
    public boolean update(Room room) {
        return false;
    }

    @Override
    public Room findById(int id) {
        return null;
    }

    @Override
    public List<Room> search(String name) {
        return null;
    }
}
