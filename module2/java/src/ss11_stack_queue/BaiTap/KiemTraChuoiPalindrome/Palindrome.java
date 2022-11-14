package ss11_stack_queue.BaiTap.KiemTraChuoiPalindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap chuoi can kiem tra: ");
        String string = input.nextLine();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue= new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            char temp = string.charAt(i);
            stack.push(temp);
            queue.add(temp);
        }
        System.out.println("Stack: " + stack);
        System.out.println("Queue: " + queue);
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.poll()) {
                System.out.println("Day khong phai la chuoi Palindrome");
                return;
            }
        }
        System.out.println("Day la chuoi Palindrome");
    }
}
