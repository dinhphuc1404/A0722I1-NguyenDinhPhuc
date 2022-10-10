package ss1_Introduction;

import java.util.Scanner;

public class bt_ung_dung_doc_so_thanh_chu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.println("Nhập số cần đọc: ");
        number = input.nextInt();
        if(number<10){
            switch (number){
                case 0 : System.out.println("không"); break;
                case 1 : System.out.println("Một"); break;
                case 2 : System.out.println("Hai"); break;
                case 3 : System.out.println("Ba"); break;
                case 4 : System.out.println("Bốn"); break;
                case 5 : System.out.println("Năm"); break;
                case 6 : System.out.println("Sáu"); break;
                case 7 : System.out.println("Bảy"); break;
                case 8 : System.out.println("Tám"); break;
                case 9 : System.out.println("Chín"); break;

            }
        } else if(number<20){
            int unit = number-10;
            switch (unit){
                case 0 : System.out.println("Mười"); break;
                case 1 : System.out.println("Mười một"); break;
                case 2 : System.out.println("Mười hai"); break;
                case 3 : System.out.println("Mười ba"); break;
                case 4 : System.out.println("Mười bốn"); break;
                case 5 : System.out.println("Mười lăm"); break;
                case 6 : System.out.println("Mười sáu"); break;
                case 7 : System.out.println("Mười bảy"); break;
                case 8 : System.out.println("Mười tám"); break;
                case 9 : System.out.println("Mười chín"); break;

            }
        } else if(number<100){
            //number/10
            switch (number/10){
                case 2 : System.out.print("Hai"); break;
                case 3 : System.out.print("Ba"); break;
                case 4 : System.out.print("Bốn"); break;
                case 5 : System.out.print("Năm"); break;
                case 6 : System.out.print("Sáu"); break;
                case 7 : System.out.print("Bảy"); break;
                case 8 : System.out.print("Tám"); break;
                case 9 : System.out.print("Chín"); break;
            }

            System.out.print(" mươi");
            // number % 10
            switch (number%10){
                case 1 :
                    System.out.println(" mốt"); break;
                case 2 : System.out.print(" hai"); break;
                case 3 : System.out.print(" ba"); break;
                case 4 : System.out.print(" bốn"); break;
                case 5 : System.out.print(" lăm"); break;
                case 6 : System.out.print(" sáu"); break;
                case 7 : System.out.print(" bảy"); break;
                case 8 : System.out.print(" tám"); break;
                case 9 : System.out.print(" chín"); break;
            }
        } else {
            switch (number/100){

            }

        }

    }
}
