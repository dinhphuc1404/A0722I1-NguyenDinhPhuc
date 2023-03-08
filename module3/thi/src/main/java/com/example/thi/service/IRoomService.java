package com.example.thi.service;

import com.example.thi.model.Room;

import java.util.List;

public interface IRoomService {
    List<Room> findAll();
    void add(Room room);
    boolean delete(int id);
    List<Room> searchLoaiMatBang(String loaiMatBang);
    List<Room> searchTang(int tang);
    List<Room> searchGia(double giaTien);
    List<Room> sort();

}
