package CaseStudy.services;

import CaseStudy.models.Employee;
import ss10_danh_sach.BaiTap.LinkedList.MyLinkedList;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService{
    private static ArrayList<Employee> list = new ArrayList<>();



    static {
        list.add(new Employee("1", "Phuc", 21,"Đà Nẵng",001,"phuc@gmail.com","Quản lí","10000000","Giám đốc"));
        list.add(new Employee("2", "A", 20,"Hà Nội",002,"a@gmail.com","Quản lí","5000000","Phó giám đốc"));
        list.add(new Employee("3", "B", 22,"Bình Dương",003,"b@gmail.com","Quản lí","7000000","Trưởng phòng"));
        list.add(new Employee("4", "C", 23,"Quảng Nam",004,"c@gmail.com","Quản lí","8000000","Phó trường phòng"));
    }

    @Override
    public void display() {
        for (int i =0; i<list.size();i++){
            System.out.println(list.get(i));
        }

    }

    @Override
    public void addNew() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập id: ");
        String id = input.nextLine();
        System.out.println("Nhập tên: ");
        String name = input.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Nhập địa chỉ: ");
        String address = input.nextLine();
        System.out.println("Nhập cccd: ");
        int idCard =  Integer.parseInt(input.nextLine());
        System.out.println("Nhập email: ");
        String email = input.nextLine();
        System.out.println("Nhập level: ");
        String level = input.nextLine();
        System.out.println("Lương: ");
        String salary = input.nextLine();
        System.out.println("Chức vụ: ");
        String position = input.nextLine();
        Employee employee = new Employee(id, name, age,address,idCard,email,level,salary,position);
        list.add(employee);
        display();
    }

    @Override
    public void edit() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào id cần sửa thông tin: ");
        String inputID = input.nextLine();// tìm id
        boolean check = false;
        for (int i=0;i< list.size();i++){
            if(list.get(i).getId().equals(inputID)){
                check = true;
                System.out.println("Nhập tên: ");
                String name = input.nextLine();
                System.out.println("Nhập tuổi: ");
                int age = Integer.parseInt(input.nextLine());
                System.out.println("Nhập địa chỉ: ");
                String address = input.nextLine();
                System.out.println("Nhập cccd: ");
                int idCard =  Integer.parseInt(input.nextLine());
                System.out.println("Nhập email: ");
                String email = input.nextLine();
                System.out.println("Nhập level: ");
                String level = input.nextLine();
                System.out.println("Lương: ");
                String salary = input.nextLine();
                System.out.println("Chức vụ: ");
                String position = input.nextLine();
                list.set(i, new Employee(inputID,name,age,address,idCard,email,level,salary,position));
                display();
            }
        }
        if(!check) {
            System.out.println("ko tìm thấy id");
        }




    }

    @Override
    public void delete() {

    }
}
