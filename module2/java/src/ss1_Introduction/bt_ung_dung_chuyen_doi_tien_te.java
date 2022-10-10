package ss1_Introduction;

import java.util.Scanner;

public class bt_ung_dung_chuyen_doi_tien_te {
    public static void main(String[] args) {
        double USD, VND , quyDoi;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào USD: ");
        USD = input.nextDouble();
        quyDoi = USD*23000;
        System.out.println(USD+ " = "+quyDoi+" VND");
    }
}
