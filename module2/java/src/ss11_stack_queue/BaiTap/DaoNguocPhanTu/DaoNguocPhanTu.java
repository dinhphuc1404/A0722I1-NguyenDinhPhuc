package ss11_stack_queue.BaiTap.DaoNguocPhanTu;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DaoNguocPhanTu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // số
        Stack<Integer> stacknum = new Stack<>();
        System.out.println("Nhập số phần tử");
        int n = input.nextInt();
        System.out.println("Nhập số");
        for (int i=0;i<n;i++){
            Integer integer = input.nextInt();
            stacknum.push(integer);
        }
        System.out.println("Số đảo ngược");
        while (!stacknum.isEmpty()){
            System.out.print(stacknum.pop());
        }
        // chuỗi
        Stack<String> stackstring = new Stack<>();
        System.out.println("Nhập vào chuỗi");
        String string = input.nextLine();
        for (int i=0;i<string.length();i++){
            stackstring.push(string.charAt(i)+"");
        }
        System.out.println("Chuỗi đảo ngược");
        for (int i=0;i<string.length();i++){
            System.out.print(stackstring.pop());
        }
    }
}
