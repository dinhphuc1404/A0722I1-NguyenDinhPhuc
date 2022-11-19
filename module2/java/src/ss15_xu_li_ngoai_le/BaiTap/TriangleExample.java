package ss15_xu_li_ngoai_le.BaiTap;

import java.util.Scanner;

public class TriangleExample {
    private static void triagle(int a, int b, int c) throws IllegalTriangleException{
        if(a+b<=c||a+c<=b||b+c<=a){
            throw new IllegalTriangleException("Tam giác không hợp lệ");
        }else {
            System.out.println("Tam giác hợp lệ");
        }

    }
    public static void main(String[] args) throws IllegalTriangleException {
        TriangleExample triangleExample = new TriangleExample();
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Nhap a");
            int a = input.nextInt();
            System.out.println("Nhap b");
            int b = input.nextInt();
            System.out.println("Nhap c");
            int c = input.nextInt();
            try {
                triangleExample.triagle(a,b,c);
            }
            catch (IllegalTriangleException e){
                System.out.println(e.getMessage());
            }
        }catch (Exception e){
            System.out.println("Nhập 3 cạnh không được âm");
        }
        input.close();
    }
}
