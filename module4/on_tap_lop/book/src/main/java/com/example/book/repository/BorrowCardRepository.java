package com.example.book.repository;

import com.example.book.entity.BorrowCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowCardRepository extends JpaRepository<BorrowCard, Long> {
}
