package com.example.quang_ly_phong_tro.service;

import com.example.quang_ly_phong_tro.entity.MotelRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface MotelRoomService {
    void create(MotelRoom motelRoom);
    void update(MotelRoom motelRoom);
    void delete(Integer id);
    List<MotelRoom> findAll();
    MotelRoom findById(Integer id);
    Page<MotelRoom> findAllWithPaging(Pageable pageable);
    public Slice<MotelRoom> findAllWithSlice(Pageable pageable);
    List<MotelRoom> findAllByNameAndEmail(String name, String email);
    void deleteAll(Integer[] ids);
    Slice<MotelRoom> findAllBySearchAll( String name, String phoneNumber, Pageable pageable);
}
