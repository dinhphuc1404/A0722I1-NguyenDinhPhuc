package com.example.quan_ly_sinh_vien.service;

import com.example.quan_ly_sinh_vien.model.Student;
import com.example.quan_ly_sinh_vien.repository.IStudentRepository;
import com.example.quan_ly_sinh_vien.repository.StudentRepositoryImpl;

import java.util.List;

public class StudentServiceImpl implements IStudentService{
    private IStudentRepository repository = new StudentRepositoryImpl();
    @Override
    public List<Student> findAall() {
        return repository.findAll();
    }

    @Override
    public void save(Student student) {
        repository.save(student);
    }

    @Override
    public boolean edit(Student student) {
         return  repository.edit(student);
    }

    @Override
    public Student selectStudent(int id) {
        return repository.selectStudent(id);
    }
}
