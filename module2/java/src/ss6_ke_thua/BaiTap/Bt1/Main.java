package ss6_ke_thua.BaiTap.Bt1;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println(circle1);
        System.out.println(circle1.getArea());
        circle1 = new Circle(2.0,"blue");
        System.out.println(circle1);
        System.out.println(circle1.getArea());

        Cylinder cylinder1 = new Cylinder(2.0,"red",5.0);
        System.out.println(cylinder1);
        System.out.println(cylinder1.getVolume());
        cylinder1 = new Cylinder(7.0,"blue",8.0);
        System.out.println(cylinder1);
        System.out.println(cylinder1.getVolume());
    }
}
