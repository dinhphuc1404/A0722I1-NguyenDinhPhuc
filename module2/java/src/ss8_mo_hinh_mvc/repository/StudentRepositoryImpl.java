package ss8_mo_hinh_mvc.repository;

import ss8_mo_hinh_mvc.model.Student;

public class StudentRepositoryImpl implements StudentRepository{
    private static Student[] studentList;
    private static int size =0;
    static{
        studentList = new Student[20];
        studentList[0] = new Student(1, "Nguyen Van A", 100);
        studentList[1] = new Student(2, "Nguyen Van B", 10);
        studentList[2] = new Student(3, "Nguyen Van C", 20);
        studentList[3] = new Student(4, "Nguyen Van D", 80);
        size = 4;
    }
    @Override
    public Student[] findAll() {
        Student[] student = new Student[size];
        for (int i=0;i<size;i++){
            student[i] = studentList[i];
        }
        return student;
    }

    @Override
    public void addStudent(Student student) {
        studentList[size] = student;
        size++;
    }

    @Override
    public void uppdateStudent(Student student) {

    }

    @Override
    public void removeStuden(Student student) {

    }

    @Override
    public void findByIndex(int index) {

    }
}
