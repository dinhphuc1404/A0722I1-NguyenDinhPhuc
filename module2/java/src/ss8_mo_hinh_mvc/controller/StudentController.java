package ss8_mo_hinh_mvc.controller;

import ss8_mo_hinh_mvc.model.Student;
import ss8_mo_hinh_mvc.service.StudentService;
import ss8_mo_hinh_mvc.service.StudentServiceImpl;

import java.util.Scanner;

public class StudentController {
    private static StudentService service = new StudentServiceImpl();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int select =0;
        do {
            System.out.println("---- Student Manager ----");
            System.out.println("1. List");
            System.out.println("2. Add");
            System.out.println("9. Exit");
            select = Integer.parseInt(input.nextLine());
            switch (select){
                case 1://List
                    Student[] students = service.findAll();
                    for (Student student: students){
                        System.out.println(student);
                    }
                    break;
                case 2 :

                case 9:
                    System.exit(0);
                    break;
            }

        }while (true);
    }
}
