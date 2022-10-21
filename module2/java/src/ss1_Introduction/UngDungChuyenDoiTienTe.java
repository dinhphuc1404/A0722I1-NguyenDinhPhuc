package ss1_Introduction;

import java.util.Scanner;

public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        double usd , quyDoi;
        double vnd = 23000;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào USD: ");
        usd = input.nextDouble();
        quyDoi = usd*vnd;
        System.out.println(usd+ " USD = "+quyDoi+" VND");
    }
}
