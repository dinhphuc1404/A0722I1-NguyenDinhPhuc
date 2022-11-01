package ss8_mo_hinh_mvc.repository;

import ss8_mo_hinh_mvc.model.Student;

public interface StudentRepository {
    Student[] findAll();
    void addStudent(Student student);
    void uppdateStudent(Student student);
    void removeStuden(Student student);
    void findByIndex(int index);
}
