package ss18_string_regex.BaiTap;

import java.util.Scanner;

public class ClassExampleTest {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhap ten class");
        String nameClass= scanner.nextLine();
        ClassExample classExample= new ClassExample();
        boolean isValid= classExample.validate(nameClass);
        if(isValid){
            System.out.println("Hợp lệ");
        }
        else {
            System.out.println("Không hợp lệ");
        }

    }
}
