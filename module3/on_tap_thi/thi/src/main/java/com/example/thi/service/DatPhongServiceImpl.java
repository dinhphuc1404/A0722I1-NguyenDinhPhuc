package com.example.thi.service;

import com.example.thi.model.DatPhong;
import com.example.thi.repository.DatPhongRepositoryImpl;

import java.util.List;

public class DatPhongServiceImpl implements DatPhongService{
    DatPhongRepositoryImpl datPhongRepository = new DatPhongRepositoryImpl();
    @Override
    public List<DatPhong> findAll() {
        return datPhongRepository.findAll();
    }

    @Override
    public void add(DatPhong datPhong) {
        datPhongRepository.add(datPhong);
    }

    @Override
    public List<DatPhong> findAllChiTiet() {
        return datPhongRepository.findAllChiTiet();
    }
}
