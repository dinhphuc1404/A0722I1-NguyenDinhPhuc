package ss1_Introduction;

import java.util.Scanner;

public class bt_hien_thi_loi_chao {
    public static void main(String[] args) {
        System.out.println("Vui lòng nhập tên: ");
        String name;
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        System.out.println("Hello " +name);
    }
}
