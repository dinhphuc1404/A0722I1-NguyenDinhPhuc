package ss1_Introduction;

import java.util.Scanner;

public class tinh_so_ngay_trong_thang {
    public static void main(String[] args) {
        int month;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn muốn tìm số ngày của tháng mấy");
        month = scanner.nextInt();
        switch (month){
            case 2:
                System.out.println("Tháng 2 có 28 hoặc 29 ngày");
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng "+month+" có 31 ngày");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.print("Tháng " + month + " có 30 ngày");
                break;
            default:
                System.out.print("Vui lòng nhập từ tháng 1 đến tháng 12");
                break;
        }
    }
}
