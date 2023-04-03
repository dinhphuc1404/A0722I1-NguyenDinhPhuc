package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.Code;

import java.util.List;

public interface CodeService {
    List<Code> findAll();
    Code findById(Integer id);
    void save(Code code);
    void delete(Integer id);
    List<Code> findAllCodeByBookId(Integer id);
    List<Code> findAvailableCodeByBookId(Integer id);
    List<Code> findUsedCodeByBookId(Integer id);
    void returnBookByCode(Book book, Integer returnCode);
}
