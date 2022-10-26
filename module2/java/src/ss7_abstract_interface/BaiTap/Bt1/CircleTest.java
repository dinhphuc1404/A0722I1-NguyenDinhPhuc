package ss7_abstract_interface.BaiTap.Bt1;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println(circle1);
        System.out.println("Trước khi thay đổi: "+circle1.getArea());
        System.out.println("Sau khi thay đổi: "+circle1.resize(3.0));
    }
}
