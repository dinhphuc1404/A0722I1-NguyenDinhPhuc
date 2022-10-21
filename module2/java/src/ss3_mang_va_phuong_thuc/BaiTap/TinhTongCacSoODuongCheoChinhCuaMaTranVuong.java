package ss3_mang_va_phuong_thuc.BaiTap;

import java.util.Scanner;

public class TinhTongCacSoODuongCheoChinhCuaMaTranVuong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập phần tử mảng :");
        int numOne = scanner.nextInt();
        int numTwo = scanner.nextInt();
        float[][] array = new float[numOne][numTwo];
        for (int i = 0; i < numOne; i++) {
            for (int j = 0; j < numTwo; j++) {
                System.out.println("Nhập giá trị mảng :");
                array[i][j] = scanner.nextFloat();
            }
        }
        int sum = 0;
        for (int i = 0; i < numOne; i++) {
            for (int j = 0; j < numTwo; j++) {
                if (i == j) {
                    sum += array[i][j];
                }
            }
        }
        System.out.println("Tổng:" + sum);
    }
}
