package ss7_abstract_interface.BaiTap.Bt2;

public class SquareTest {
    public static void main(String[] args) {
        Square square1 = new Square();
        square1.howToCoLor();
        System.out.println(square1);

        System.out.println("--------------");
        Shape[] shapes = new Shape[1];
        shapes[0] = new Square();
        for (int i = 0;i<shapes.length;i++){
            System.out.println(shapes[i]);
            if(shapes[i] instanceof Square){
                ((Square) shapes[i]).howToCoLor();
            }
        }

    }
}
