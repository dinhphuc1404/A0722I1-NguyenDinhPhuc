package ss3_mang_va_phuong_thuc.BaiTap;

import java.util.Scanner;

public class TinhTongCacSoOMotCotXacDinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float[][] arr;
        System.out.print("Nhập chiều dài mảng: ");
        int rows = sc.nextInt();
        System.out.print("Nhập cột: ");
        int colums = sc.nextInt();
        arr = new float[colums][rows];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Input the element at [" + i + "][" + j + "]: ");
                arr[i][j] = sc.nextFloat();
            }
        }
        System.out.println("Mảng: ");
        for (float[] floats : arr) {
            for (float itums : floats) {
                System.out.print(itums + "\t");
            }
            System.out.println();
        }

        System.out.print("Bạn muốn tính tổng cột nào: ");
        int colum = sc.nextInt();
        float sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][colum];
        }
        System.out.println("Tổng của cột " + colum + " = " + sum);
    }
}
