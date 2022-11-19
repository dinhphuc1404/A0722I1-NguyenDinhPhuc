package ss15_xu_li_ngoai_le.ThucHanh;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Th1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào số");
        int n = input.nextInt();
        try {

            System.out.println(n);
        }catch (InputMismatchException e){
            System.out.println("Nhập số th ngu");
        }
    }
}
