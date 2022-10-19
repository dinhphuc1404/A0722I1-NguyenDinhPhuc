package ss1_Introduction;

import java.util.Scanner;

public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        double USD , quyDoi;
        double VND = 23000;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào USD: ");
        USD = input.nextDouble();
        quyDoi = USD*VND;
        System.out.println(USD+ " USD = "+quyDoi+" VND");
    }
}
