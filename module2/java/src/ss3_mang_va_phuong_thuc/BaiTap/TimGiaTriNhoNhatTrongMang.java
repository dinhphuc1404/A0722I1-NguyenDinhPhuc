package ss3_mang_va_phuong_thuc.BaiTap;

import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Nhập vào số phần tử mảng");
            n = input.nextInt();
        }while (n<=0);
        int arr[] = new int[n];
        for (int i=0;i<n;i++){
            System.out.println("Phần tử thứ "+(i+1));
            arr[i] = input.nextInt();
        }
        System.out.println("Mảng vừa nhập");
        for (int j=0; j<arr.length;j++){
            System.out.print(arr[j]+"\t");
        }
        int min = arr[0];
        for (int k =0; k< arr.length;k++){
            if(arr[k]<min){
                min = arr[k];
            }
        }
        System.out.println("Giá trị nhỏ nhất là: "+min);
    }
}
