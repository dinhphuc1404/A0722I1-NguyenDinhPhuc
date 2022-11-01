package ss8_mo_hinh_mvc.service;

import ss8_mo_hinh_mvc.model.Student;
import ss8_mo_hinh_mvc.repository.StudentRepository;
import ss8_mo_hinh_mvc.repository.StudentRepositoryImpl;

public class StudentServiceImpl implements StudentService{
    private StudentRepository repository = new StudentRepositoryImpl();
    @Override
    public Student[] findAll() {
        return repository.findAll();
    }

    @Override
    public void addStudent(Student student) {
       repository.addStudent(student);

    }

    @Override
    public void uppdateStudent(Student student) {
        repository.uppdateStudent(student);

    }

    @Override
    public void removeStuden(Student student) {
        repository.removeStuden(student);
    }

    @Override
    public void findByIndex(int index) {
        repository.findByIndex(index);
    }
}
