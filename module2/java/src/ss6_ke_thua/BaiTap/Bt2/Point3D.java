package ss6_ke_thua.BaiTap.Bt2;

public class Point3D extends Point2D{
    private float z =0.0f;
      Point3D(){

    }

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x,float y, float z){
          this.setX(x);
          this.setY(y);
          this.z = z;
    }
    public float[] getXYZ(){
          float[] array3D = {this.getX(), this.getY(),z};
          return array3D;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + this.getX() +
                ", y=" + this.getY() +
                ", z=" + z +
                '}';
    }
}
