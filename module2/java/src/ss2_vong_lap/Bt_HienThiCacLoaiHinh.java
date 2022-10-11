package ss2_vong_lap;

import java.util.Scanner;

public class Bt_HienThiCacLoaiHinh {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice!=0){
            System.out.println("Menu");
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the square");
            System.out.println("3. Draw the rectangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice=input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Nhap vao m");
                    int m=input.nextInt();

                    System.out.println("Nhap vao n");
                    int n=input.nextInt();
                    if(m>0&&n>0){
                        for(int i=1;i<=m;i++){
                            for(int j=1;j<=n;j++){
                                System.out.print("*");
                            }
                            System.out.println();
                        }

                    } break;
                case 2:
                    System.out.println("Nhap vao h");
                    int h=input.nextInt();
                    if(h>0){
                        for (int i=1;i<=h;i++){
                            for(int j=1;j<=i;j++){
                                System.out.print("*");

                            }
                            System.out.println();
                        }
                    } break;
                case 3:
                    System.out.print("Nhap vao h: ");
                    int hh = input.nextInt();
                    if(hh>0){
                        for (int i=hh;i>=1;i--){
                            for (int j=1; j<=i;j++){
                                System.out.print("*");
                            }
                            System.out.println();
                        }
                    } break;

                case 0:
                    System.exit(0);

            }

        }
    }
}
