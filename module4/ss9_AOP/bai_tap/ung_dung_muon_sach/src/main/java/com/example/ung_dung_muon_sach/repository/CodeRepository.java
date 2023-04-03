package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CodeRepository extends JpaRepository<Code, Integer> {
    List<Code> findCodeByBook_Id(Integer id);
    List<Code> findCodeByBook_IdAndStatus_Id(Integer bookId, Integer statusId);
}
