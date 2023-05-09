package com.example.book.service;

import com.example.book.entity.BorrowCard;

import java.util.List;

public interface BorrowCardService {
    List<BorrowCard> getAllBorrowCards();
    void addBorrowCard(BorrowCard borrowCard);
    void updateBorrowCard(BorrowCard borrowCard);
    void deleteBorrowCardById(Long id);
    BorrowCard getBorrowCardById(Long id);
    void returnBook(Long id);
}
