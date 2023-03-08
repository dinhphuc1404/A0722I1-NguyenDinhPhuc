package com.example.quan_ly_thue_phong_tro.service;

import com.example.quan_ly_thue_phong_tro.model.Room;
import com.example.quan_ly_thue_phong_tro.repository.RoomRepositoryImpl;

import java.util.List;

public class RomServiceImpl implements IRomService{
    RoomRepositoryImpl repository = new RoomRepositoryImpl();
    @Override
    public List<Room> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }


    @Override
    public void add(Room room) {
        repository.add(room);
    }

    @Override
    public boolean update(Room room) {
        return repository.update(room);
    }

    @Override
    public Room findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Room> search(String name) {
        return repository.search(name);
    }
}
