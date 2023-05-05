package com.example.quang_ly_phong_tro.service;

import com.example.quang_ly_phong_tro.entity.MotelRoom;
import com.example.quang_ly_phong_tro.repository.MotelRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MotelRoomServiceImpl implements MotelRoomService{
    @Autowired
    MotelRoomRepository motelRoomRepository;

    @Override
    public void create(MotelRoom motelRoom) {
        motelRoomRepository.save(motelRoom);
    }

    @Override
    public void update(MotelRoom motelRoom) {
        motelRoomRepository.save(motelRoom);
    }

    @Override
    public void delete(Integer id) {
        motelRoomRepository.deleteById(id);
    }

    @Override
    public List<MotelRoom> findAll() {
        return motelRoomRepository.findAll();
    }

    @Override
    public MotelRoom findById(Integer id) {
        return motelRoomRepository.findById(id).orElse(null);
    }

    @Override
    public Page<MotelRoom> findAllWithPaging(Pageable pageable) {
        return motelRoomRepository.findAll(pageable);
    }

    @Override
    public Slice<MotelRoom> findAllWithSlice(Pageable pageable) {
        return motelRoomRepository.findAll(pageable);
    }

    @Override
    public List<MotelRoom> findAllByNameAndEmail(String name, String email) {
        return null;
    }

    @Override
    public void deleteAll(Integer[] ids) {
        motelRoomRepository.deleteAllByIdIn(ids);
    }

    @Override
    public Slice<MotelRoom> findAllBySearchAll( String name, String phoneNumber, Pageable pageable) {
        return motelRoomRepository.findAllByNameContainsOrPhoneNumberContains(name,phoneNumber,pageable);
    }
}
