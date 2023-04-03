package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.Code;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    void save(Book book);
    void delete(Integer id);
    void borrow(Book book, Integer usedCode);
    void returnBook(Book book, Integer returnCode);
    Book findById(Integer id);
    Code getNextAvailableCode(Book book);
}
