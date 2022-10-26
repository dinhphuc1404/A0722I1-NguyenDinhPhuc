package ss7_abstract_interface.BaiTap.Bt1;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);
        System.out.println("Trước khi thay đổi: "+rectangle.getArea());
        System.out.println("Sau khi thay đổi: "+rectangle.resize(3.0));
    }
}
