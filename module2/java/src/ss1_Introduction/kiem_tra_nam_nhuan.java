package ss1_Introduction;

import java.util.Scanner;

public class kiem_tra_nam_nhuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;
        System.out.println("Nhập vào năm: ");
        year = scanner.nextInt();
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    System.out.println("Năm"+year+" là năm nhuận");
                } else {
                    System.out.println("Không phải là năm nhuận");
                }
            } else {
                System.out.println("Năm "+year+" là năm nhuận");
            }
        } else {
            System.out.println("Không phải năm nhuận");
        }
    }
}
