package com.example.thi.repository;

import com.example.thi.model.DatPhong;

import java.util.List;

public interface DatPhongRepository {
    List<DatPhong> findAll();
    void add(DatPhong datPhong);
    List<DatPhong> findAllChiTiet();
}
