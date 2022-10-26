package ss7_abstract_interface.BaiTap.Bt2;

public class Square extends Shape implements Colorable{
    private double size = 1.0;
    public Square(){

    }

    public Square(double size) {
        this.size = size;
    }

    public Square(String color, boolean filled, double size) {
        super(color, filled);
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
    public double getArea(){
        return size*size;
    }
    public double getPerimeter() {
        return 4 * size;
    }

    @Override
    public String toString() {
        return super.toString()+ ", chu vi là: "+getPerimeter()+", diện tích là: "+getArea();
    }

    @Override
    public void howToCoLor() {
        System.out.println("Color all four sides");
    }
}
