package CaseStudy.services;

import CaseStudy.models.Facility;
import CaseStudy.models.House;
import CaseStudy.models.Room;
import CaseStudy.models.Villa;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService{
     private static LinkedHashMap<Facility,Integer> facility = new LinkedHashMap<>();
    static {
        facility.put(new Villa("Villa",5000000,"Tháng","500m2","Thường",3,"200m"),0);
        facility.put(new House("House",500000,"Ngày", "1000m2","VIP", 2),0);
        facility.put(new Room("Room",150000,"Ngày","200m2","Sân thượng"),0);

    }

    @Override
    public void display() {
        for(Map.Entry<Facility,Integer> item : facility.entrySet()){
            System.out.printf("%s - %s",item.getKey(),item.getValue());
            System.out.println();

        }
    }
    @Override
    public void addNew() {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1.Add New Villa\n" +
                    "2.Add New House\n" +
                    "3.Add New Room\n" +
                    "4.Back to menu");
            System.out.println("Chọn số: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    Villa tempVilla = addNewVilla();
                    facility.put(tempVilla,0);
                    display();
                    break;
                case 2:
                    House tempHouse = addNewHouse();
                    facility.put(tempHouse,0);
                    display();
                    break;
                case 3:
                    Room tempRoom = addNewRoom();
                    facility.put(tempRoom,0);
                    display();
                    break;
                case 4:break;
            }
        } while (choice < 4);
    }
    public Villa addNewVilla(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên dịch vụ: ");
        String name = input.nextLine();
        System.out.println("Nhập giá: ");
        double price = Integer.parseInt(input.nextLine());
        System.out.println("Nhập kiểu: ");
        String type = input.nextLine();
        System.out.println("Khu vực có thể sử dụng được: ");
        String usableArea = input.nextLine();
        System.out.println("Tiêu chuẩn phòng: ");
        String roomStandard = input.nextLine();
        System.out.println("Số tầng: ");
        int numberOfFloors = Integer.parseInt(input.nextLine());
        System.out.println("Diện tích hồ bơi");
        String poolArea = input.nextLine();
        return new Villa(name,price,type,usableArea,roomStandard,numberOfFloors,poolArea);

    }
    public Room addNewRoom(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên dịch vụ: ");
        String name = input.nextLine();
        System.out.println("Nhập giá: ");
        double price = Integer.parseInt(input.nextLine());
        System.out.println("Nhập kiểu: ");
        String type = input.nextLine();
        System.out.println("Khu vực có thể sử dụng được: ");
        String usableArea = input.nextLine();
        System.out.println("Khu vực miễn phí: ");
        String freeService = input.nextLine();
        return new Room(name,price,type,usableArea,freeService);
    }

    public House addNewHouse(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên dịch: ");
        String name = input.nextLine();
        System.out.println("Nhập giá: ");
        double price = Integer.parseInt(input.nextLine());
        System.out.println("Nhập kiểu: ");
        String type = input.nextLine();
        System.out.println("Khu vực có thể sử dụng được: ");
        String usableArea = input.nextLine();
        System.out.println("Tiêu chuẩn phòng: ");
        String roomStandard = input.nextLine();
        System.out.println("Số tầng: ");
        int numberOfFloors = Integer.parseInt(input.nextLine());
        return new House(name,price,type,usableArea,roomStandard,numberOfFloors);
    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }

}
