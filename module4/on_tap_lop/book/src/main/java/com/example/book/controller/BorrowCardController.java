package com.example.book.controller;

import com.example.book.entity.Book;
import com.example.book.entity.BorrowCard;
import com.example.book.entity.Student;
import com.example.book.service.BookService;
import com.example.book.service.BorrowCardService;
import com.example.book.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/borrowcard")
public class BorrowCardController {

    @Autowired
    private BorrowCardService borrowCardService;

    @Autowired
    private BookService bookService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public String getAllBorrowCards(Model model) {
        List<BorrowCard> borrowCards = borrowCardService.getAllBorrowCards();
        model.addAttribute("borrowCards", borrowCards);
        return "borrowcard/list";
    }

    @GetMapping("/add")
    public String showAddForm(BorrowCard borrowCard, Model model) {
        List<Book> books = bookService.getAllBooks();
        List<Student> students = studentService.getAllStudents();
        borrowCard.setBook(new Book());
        borrowCard.setStudent(new Student());
        model.addAttribute("borrowCard",borrowCard);
        model.addAttribute("books",books);
        model.addAttribute("students",students);
        return "/borrowcard/add";
    }

    @PostMapping("/add")
    public String addBorrowCard(@Valid BorrowCard borrowCard, BindingResult result) {
        if (result.hasErrors()) {
            return "/borrowcard/add";
        }
        borrowCardService.addBorrowCard(borrowCard);
        return "redirect:/borrow-cards";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        BorrowCard borrowCard = borrowCardService.getBorrowCardById(id);
        model.addAttribute("borrowCard", borrowCard);
        return "/borrowcard/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateBorrowCard(@PathVariable("id") Long id, @Valid BorrowCard borrowCard, BindingResult result) {
        if (result.hasErrors()) {
            return "/borrowcard/edit";
        }
        borrowCardService.updateBorrowCard(borrowCard);
        return "redirect:/borrowcard/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBorrowCard(@PathVariable("id") Long id) {
        borrowCardService.deleteBorrowCardById(id);
        return "redirect:/borrowcard/list";
    }

    @GetMapping("/return/{id}")
    public String returnBook(@PathVariable("id") Long id) {
        borrowCardService.returnBook(id);
        return "redirect:/borrocard/list";
    }
}
