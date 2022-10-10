package ss1_Introduction;

import java.util.Scanner;

public class tinh_chi_so_can_nang_cua_co_the {
    public static void main(String[] args) {
        double weight, height, bmi;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào cân nặng");
        weight = input.nextDouble();
        System.out.println("Nhập vào chiều cao");
        height = input.nextDouble();
        bmi =  weight / Math.pow(height, 2);
        if(bmi<18.5){
            System.out.println(bmi+": Thiếu cân");
        } else if(bmi<25.0){
            System.out.println(bmi+": Bình thường");
        } else if (bmi<30.0){
            System.out.println(bmi+": Thừa cân");
        } else {
            System.out.println(bmi+": Béo phì");
        }
    }
}
