package ss3_mang_va_phuong_thuc.ThucHanh;

import java.util.Scanner;

public class DaoNguocCacPhanTuMang {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Nhập vào phần tử");
            size = input.nextInt();
            if (size>20){
                System.out.println("Vui long nhập nhỏ hơn 20");
            }
        }while (size>20);
        array = new int[size];
        int i=0;
        while (i<array.length){
            System.out.println("Phần tử thứ "+(i+1)+" :");
            array[i] = input.nextInt();
            i++;
        }
        System.out.println("Mảng vừa nhập");
        for (int j=0; j<array.length;j++){
            System.out.print(array[j]+ "\t");
        }
        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        System.out.println("\nMảng đảo ngược");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
