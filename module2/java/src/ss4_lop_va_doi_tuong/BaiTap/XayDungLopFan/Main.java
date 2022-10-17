package ss4_lop_va_doi_tuong.BaiTap.XayDungLopFan;

public class Main {
    public static void main(String[] args) {
        Fan fanA = new Fan();
        Fan fanB = new Fan();
        fanA.setSpeed(10);
        fanA.setRadius(10);
        fanA.setColor("yellow");
        fanA.setOn(true);

        fanB.setSpeed(5);
        fanB.setRadius(5);
        fanB.setColor("bue");
        fanB.setOn(false);
        System.out.println(fanA.toString());
        System.out.println(fanB.toString());
    }
}
