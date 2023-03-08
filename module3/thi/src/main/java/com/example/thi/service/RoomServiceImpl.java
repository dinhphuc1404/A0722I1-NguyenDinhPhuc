package com.example.thi.service;

import com.example.thi.model.Room;
import com.example.thi.repository.RoomRepositoryImpl;

import java.util.List;

public class RoomServiceImpl implements IRoomService {
    RoomRepositoryImpl repository = new RoomRepositoryImpl();

    @Override
    public List<Room> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(Room room) {
        repository.add(room);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public List<Room> searchLoaiMatBang(String loaiMatBang) {
        return repository.searchLoaiMatBang(loaiMatBang);
    }

    @Override
    public List<Room> searchTang(int tang) {
        return repository.searchTang(tang);
    }

    @Override
    public List<Room> searchGia(double giaTien) {
        return repository.searchGia(giaTien);
    }

    @Override
    public List<Room> sort() {
        return repository.sort();
    }
}
