package ss4_lop_va_doi_tuong.BaiTap.XayDungLopQuadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a,b,c;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập a");
        a = input.nextDouble();
        System.out.println("Nhap b");
        b = input.nextDouble();
        System.out.println("Nhap c");
        c = input.nextDouble();
        QuadraticEquation equation = new  QuadraticEquation(a,b,c);
        if(equation.getDiscriminant()<0){
            System.out.println("Phương trình vô nghiệm");
        } else if(equation.getDiscriminant()==0){
            System.out.println("Phương trình có nghiệm kép: "+equation.getRoot1());

        }else {
            System.out.println("Phương trình có 2 nghiệm: ");
            System.out.println("Nghiệm 1: "+equation.getRoot1());
            System.out.println("Nghiệm 2: "+equation.getRoot2());
        }

    }
}
