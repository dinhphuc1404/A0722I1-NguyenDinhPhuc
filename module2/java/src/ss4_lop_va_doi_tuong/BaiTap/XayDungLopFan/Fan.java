package ss4_lop_va_doi_tuong.BaiTap.XayDungLopFan;

public class Fan {

    private static final int SlOW = 1;
    private static final int MEDIUM = 2;
    private static final int FAST = 3;
    private int speed;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (on) {
            return "fan is on, speed = " + this.getSpeed() +  ", radius = " + this.getRadius() + ", color: " + this.getColor();
        } else {
            return "fan is off, radius = " + this.getRadius() + ", color: " +this.getColor();
        }
    }
}
