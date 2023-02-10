package com.example.quan_ly_sinh_vien.service;

import com.example.quan_ly_sinh_vien.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAall();

    void save(Student student);

    boolean edit(Student student);

    Student selectStudent(int id);
}
