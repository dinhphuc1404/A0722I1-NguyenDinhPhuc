package ss4_lop_va_doi_tuong.ThucHanh;

public class HinhChuNhat {
    double dai, rong;
    public HinhChuNhat(){

    }
    public HinhChuNhat(double dai, double rong){
        this.dai = dai;
        this.rong = rong;
    }
    public double getDienTich(){
        return this.dai * this.rong;
    }
    public  double getChuVi(){
        return (this.dai+this.rong)*2;
    }
    public String xuat(){
        return "HinhChuNhat{" + "width=" + dai + ", height=" + rong + "}";
    }
}
