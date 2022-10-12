package ss3_mang_va_phuong_thuc.BaiTap;

import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        int n,i,j, x;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Nhập vào số phần tử của mảng");
            n = input.nextInt();
        } while (n<=0);
        int arr[] = new int[n];
        for ( i=0;i<n;i++){
            System.out.println("Phần tử thứ: "+(i+1));
            arr[i] = input.nextInt();
        }
        System.out.println("Mảng vừa nhập");
        for ( j=0; j<arr.length;j++){
            System.out.print(arr[j]+ "\t");
        }
        System.out.println("\nNhập số cần xóa");
        x = input.nextInt();
        // xóa phần tử x ra khỏi mảng
        // vòng lặp for sẽ khởi tạo j = i = 0
        // và duyệt i từ 0 đến n
        // nếu phần tử tại vị trí i khác với số nguyên x
        // thì gán phần tử tại i cho phần tử tại j
        // sau đó tăng j lên 1
        for (j=i=0;i<n;i++){
            if(arr[i]!=x){
                arr[j] = arr[i];
                j++;
            }
        }
        n=j;
        System.out.println("Mảng còn lại sau khi xóa phẩn tử "+x+" là");
        for (i=0;i<n;i++){
            System.out.print(arr[i]+"\t");
        }
    }
}
