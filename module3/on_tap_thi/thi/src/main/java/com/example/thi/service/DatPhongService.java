package com.example.thi.service;

import com.example.thi.model.DatPhong;

import java.util.List;

public interface DatPhongService {
    List<DatPhong> findAll();
    void add(DatPhong datPhong);
    List<DatPhong> findAllChiTiet();

}
