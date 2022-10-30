package ss6_ke_thua.BaiTap.Bt2;

public class Main {
    public static void main(String[] args) {
        PointTwoD point2D = new PointTwoD();
        System.out.println(point2D);
        point2D = new PointTwoD(3.0f, 7.0f);
        System.out.println(point2D);

        PointThreeD point3D = new PointThreeD();
        System.out.println(point3D);
        point3D = new PointThreeD(8.0f, 4.0f, 10.0f);
        System.out.println(point3D);
    }
}
