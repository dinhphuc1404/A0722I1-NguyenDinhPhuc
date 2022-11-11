package ss12_java_collection_framework.ThucHanh.TH2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Phuc", 21,"Quảng Nam");
        Student student2 = new Student("Hau", 19,"Đà Nẵng");
        Student student3 = new Student("Hung", 21,"Quy Nhơn");
        Map<Integer, Student> studentMap = new HashMap<Integer,Student>();
        studentMap.put(1,student1);
        studentMap.put(2,student2);
        studentMap.put(3,student3);
        studentMap.put(4,student1);
        for (Map.Entry<Integer,Student> studentEntry : studentMap.entrySet()){
            System.out.println(studentEntry.toString());
        }
        System.out.println("-----set-----");
        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student1);
        for (Student student : students){
            System.out.println(student.toString());
        }
    }
}
