package ss17_IOFileBnary.BaiTap;

import java.util.Scanner;

public class MainProduct {
    public static void main(String[] args) {
        TestProduct testProduct= new TestProduct();

        boolean check=true;
        while (check){
            Scanner scanner= new Scanner(System.in);
            System.out.println("Nhập 1 để add");
            System.out.println("Nhap 2 để in");
            switch (scanner.nextInt()) {
                case 1: {
                    testProduct.add();
                    break;

                }
                case 2:{
                    testProduct.display();
                    break;
                }
            }
        }





    }

}
