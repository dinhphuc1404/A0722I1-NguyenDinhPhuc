package ss6_ke_thua.BaiTap.Bt2;

public class PointTwoD {
    private float x = 0.0f;
    private float y = 0.0f;
    public PointTwoD(){

    }

    public PointTwoD(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y){
        this.x=x;
        this.y=y;
    }
    public float[] getXY(){
        float[] array2D = {x,y};
        return array2D;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
