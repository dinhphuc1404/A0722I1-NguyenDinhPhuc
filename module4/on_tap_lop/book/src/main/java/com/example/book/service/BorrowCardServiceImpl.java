package com.example.book.service;

import com.example.book.entity.Book;
import com.example.book.entity.BorrowCard;
import com.example.book.repository.BookRepository;
import com.example.book.repository.BorrowCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BorrowCardServiceImpl implements BorrowCardService{
    @Autowired
    private BorrowCardRepository borrowCardRepository;

    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<BorrowCard> getAllBorrowCards() {
        return borrowCardRepository.findAll();
    }

    @Override
    public void addBorrowCard(BorrowCard borrowCard) {
        borrowCardRepository.save(borrowCard);
    }

    @Override
    public void updateBorrowCard(BorrowCard borrowCard) {
        borrowCardRepository.save(borrowCard);
    }

    @Override
    public void deleteBorrowCardById(Long id) {
        borrowCardRepository.deleteById(id);
    }

    @Override
    public BorrowCard getBorrowCardById(Long id) {
        return borrowCardRepository.findById(id).orElse(null);
    }

    @Override
    public void returnBook(Long id) throws EntityNotFoundException {
        BorrowCard loan = borrowCardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy phiếu mượn có ID " + id));

        // Kiểm tra trạng thái của phiếu mượn
        if (!loan.isStatus()) {
        }
        // Cập nhật trạng thái phiếu mượn và số lượng sách còn lại
        loan.setStatus(false);
        Book book = loan.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
        borrowCardRepository.save(loan);
    }
}
