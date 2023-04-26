package com.example.quang_ly_phong_tro.repository;

import com.example.quang_ly_phong_tro.entity.MotelRoom;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotelRoomRepository extends JpaRepository<MotelRoom, Integer> {
    void deleteAllByIdIn(Integer[] ids);
    List<MotelRoom> findAllByNameContainsOrPhoneNumberContains(String name, String phoneNumber);
    List<MotelRoom> findAllByNameContainsAndPhoneNumberContains(String name, String phoneNumber);
}
