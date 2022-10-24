package ss6_ke_thua.BaiTap.Bt1;

public class Cylinder extends Circle{
    private double height = 4.0;
    Cylinder(){
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return Math.PI*Math.pow(getArea(),2)*this.height;
    }

    @Override
    public String toString() {
        return "Cylinder" +
                "height =" + height +", color ="+super.getColor()+", radius = "+super.getRadius();

    }
}
