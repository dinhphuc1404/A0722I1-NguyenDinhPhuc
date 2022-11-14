package ss11_stack_queue.BaiTap.ChuyenDoiThapPhanSangNhiPhan;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Integer> stack = new Stack();
        System.out.print("Nhập số cần chuyển: ");
        int i = input.nextInt();
        while(i!=0) {
            int temp = i%2;
            stack.push(temp);
            i = i/2;
        }
        System.out.print("Số nhị phân là: ");
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
