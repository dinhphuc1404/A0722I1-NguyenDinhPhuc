package ss3_mang_va_phuong_thuc.BaiTap;

import java.util.Scanner;

public class TimPhanTuLonNhatTrongMangHaiChieu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        float[][] arr;
        System.out.print("Nhap chieu rong mang: ");
        int row = sc.nextInt();
        System.out.print("Nhap chieu sau mang: ");
        int col = sc.nextInt();
        arr = new float[col][row];
        for (int i = 0; i<arr.length; i++) {
            for (int j =0 ; j<arr[i].length; j++) {
                System.out.print("Nhap vao phan tu thu ["+i+"]["+j+"]: ");
                arr[i][j] = sc.nextFloat();
            }
        }
        System.out.println("Mang da nhap la: ");
        for (float[] floats : arr) {
            for (float itums : floats) {
                System.out.print(itums + "\t");
            }
            System.out.println();
        }
        float max = arr[0][0];
        for (float[] floats : arr) {
            for (float itums : floats) {
                if (itums > max) {
                    max = itums;
                }
            }
        }
        System.out.println("Gia tri lon nhat trong mang la: "+max);

    }
}
