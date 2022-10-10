package ss1_Introduction;

import java.util.Scanner;

public class phuong_trinh_bac_1 {
    public static void main(String[] args) {
        int a ,b;

        System.out.println("Giải Ax+b=0");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập a:");
        a = scanner.nextInt();
        System.out.println("Nhập b:");
        b = scanner.nextInt();
        if(a==0){
            if(b==0) {
                System.out.println("Vô số nghiệm");
            }   else {
                System.out.println("Pt vô nghiệm");
            }
        } else {
            float nghiem =(float) (-b)/a;
            System.out.println("Phương trình có nghiệm x =  "+ nghiem);
        }

    }
}
