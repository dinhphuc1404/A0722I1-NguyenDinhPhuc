package com.example.quan_ly_sinh_vien.repository;

import com.example.quan_ly_sinh_vien.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void save(Student student);

    boolean edit(Student student);
    Student selectStudent(int id);
}
