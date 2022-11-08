package CaseStudy.services;

import CaseStudy.models.Customer;

import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService{
    private static LinkedList<Customer> list= new LinkedList<>();
    static {
        list.add(new Customer("1", "Hi",23, "Đà Nẵng",123,"abc@gmail.com","Diamond"));
        list.add(new Customer("2", "A",20, "Hà Nội",123,"ab1@gmail.com","Platinium"));
        list.add(new Customer("3", "B",19, "TP HCM",123,"ab2@gmail.com","Gold"));
        list.add(new Customer("4", "C",17, "Quảng Nam",123,"ab3@gmail.com","Silver"));
        list.add(new Customer("5", "D",18, "Huế",123,"ab4@gmail.com","Member"));

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
        System.out.println("Nhập id:");
        String id = input.nextLine();
        System.out.println("Nhập tên: ");
        String name = input.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Nhập địa chỉ: ");
        String address = input.nextLine();
        System.out.println("Nhập CMND: ");
        int idCard = Integer.parseInt(input.nextLine());
        System.out.println("Nhập gmail: ");
        String email = input.nextLine();
        System.out.println("Nhập kiểu: ");
        String tyle = input.nextLine();
        Customer customer = new Customer(id,name,age,address,idCard,email,tyle);
        list.add(customer);
        display();

    }

    @Override
    public void edit() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào id cần sửa thông tin");
        String inputId = input.nextLine();
        boolean check = false;
        for (int i=0; i< list.size();i++){
            if(list.get(i).getId().equals(inputId)){
                check = true;
                System.out.println("Nhập tên: ");
                String name = input.nextLine();
                System.out.println("Nhập tuổi: ");
                int age = Integer.parseInt(input.nextLine());
                System.out.println("Nhập địa chỉ: ");
                String address = input.nextLine();
                System.out.println("Nhập CMND: ");
                int idCard = Integer.parseInt(input.nextLine());
                System.out.println("Nhập gmail: ");
                String email = input.nextLine();
                System.out.println("Nhập kiểu: ");
                String tyle = input.nextLine();
                list.set(i,new Customer(inputId,name,age,address,idCard,email,tyle));
                display();

            }
        }
        if(!check){
            System.out.println("Không tìm thấy id");
        }
    }

    @Override
    public void delete() {

    }
}
