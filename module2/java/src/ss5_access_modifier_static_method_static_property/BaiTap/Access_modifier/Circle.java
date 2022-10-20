package ss5_access_modifier_static_method_static_property.BaiTap.Access_modifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

     Circle() {
    }

     Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public double getArea(){
         return Math.PI*Math.pow(this.radius,2);
    }

    @Override
    public String toString() {
        return "Diện tích của hình tròn có bán kính "+this.getRadius()+" là: "+this.getArea();
    }
}
