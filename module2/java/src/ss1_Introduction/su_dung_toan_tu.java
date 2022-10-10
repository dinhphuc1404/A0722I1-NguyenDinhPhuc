package ss1_Introduction;

import java.util.Scanner;

public class su_dung_toan_tu {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in); //khai báo đối tượng
        System.out.println("Nhập chiều rộng");
        width = scanner.nextFloat();
        System.out.println("Nhập chiều dài");
        height = scanner.nextFloat();
        float area = width*height;
        System.out.println("Area is "+area);

    }
}
