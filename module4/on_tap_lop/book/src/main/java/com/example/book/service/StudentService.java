package com.example.book.service;

import com.example.book.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentById(Long id);
    Student getStudentById(Long id);
}
