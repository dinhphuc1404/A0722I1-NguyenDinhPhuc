package thi.until;
import thi.model.TaiKhoanThanhToan;
import thi.model.TaiKhoanTietKiem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    final static String TAIKHOAN_TIETKIEM = "E:\\Codegym\\6 module\\module2\\java\\src\\thi\\data\\taikhoantietkiem.csv";
    final static String TAIKHOAN_THANHTOAN = "E:\\Codegym\\6 module\\module2\\java\\src\\thi\\data\\taikhoanthanhtoan.csv ";

    public static List<TaiKhoanTietKiem> ReadtaiKhoanTietKiems() throws IOException {
        List<TaiKhoanTietKiem> tietKiemList = new ArrayList<>();
        FileReader fileReader = new FileReader(TAIKHOAN_TIETKIEM);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
         String line;
         String[] temp;
         TaiKhoanTietKiem tietKiem;
        while ((line = bufferedReader.readLine()) != null){
            temp = line.split(",");
            int id = Integer.parseInt(temp[0]);
            String maTaiKhoan = temp[1];
            String tenChuTaiKhoan = temp[2];
            String ngayTaoTaiKhoan = temp[3];
            double soTienGui = Double.parseDouble(temp[4]);
            String ngayGui = temp[5];
            String laiSuat = temp[6];
            int kiHan = Integer.parseInt(temp[7]);
            tietKiem = new TaiKhoanTietKiem (id,maTaiKhoan,tenChuTaiKhoan,ngayTaoTaiKhoan,soTienGui,ngayGui,laiSuat,kiHan);
            tietKiemList.add(tietKiem);
        }
        bufferedReader.close();



      return tietKiemList;
    }
    public static List<TaiKhoanThanhToan> ReadtaiKhoanThanhToan() throws IOException {
        List<TaiKhoanThanhToan> thanhToans = new ArrayList<>();
        FileReader fileReader = new FileReader(TAIKHOAN_THANHTOAN);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String[] temp;
        TaiKhoanThanhToan thanhToan;
        while ((line = bufferedReader.readLine()) != null){
            temp = line.split(",");
            int id = Integer.parseInt(temp[0]);
            String maTaiKhoan = temp[1];
            String tenChuTaiKhoan = temp[2];
            String ngayTaoTaiKhoan = temp[3];
            String soThe = temp[4];
            double soTienTrongTaiKhoan = Double.parseDouble(temp[5]);
            thanhToan = new TaiKhoanThanhToan(id,maTaiKhoan,tenChuTaiKhoan,ngayTaoTaiKhoan,soThe,soTienTrongTaiKhoan);
            thanhToans.add(thanhToan);

        }
        bufferedReader.close();
        return thanhToans;


    }
    public static void writeTaiKhoanTietKiem(List<TaiKhoanTietKiem> taiKhoanTietKiemList) throws IOException {
        FileWriter fileWriter = new FileWriter(TAIKHOAN_TIETKIEM,false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (TaiKhoanTietKiem taiKhoanTietKiem: taiKhoanTietKiemList){
            bufferedWriter.write(taiKhoanTietKiem.getId()+","+taiKhoanTietKiem.getMaTaiKhoan()+","+taiKhoanTietKiem.getTenChuTaiKhoan()+","+taiKhoanTietKiem.getNgayTaoTaiKhoan()+
                    ","+taiKhoanTietKiem.getTienGui()+","+taiKhoanTietKiem.getNgayGui()+","+taiKhoanTietKiem.getLaiSuat()+","+taiKhoanTietKiem.getKiHan() +"\n");
        }

        bufferedWriter.close();
    }
    public static void writeTaiKhoanThanhToan(List<TaiKhoanThanhToan> taiKhoanThanhToanList) throws IOException {
        FileWriter fileWriter = new FileWriter(TAIKHOAN_THANHTOAN,false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (TaiKhoanThanhToan taiKhoanThanhToan: taiKhoanThanhToanList){
            bufferedWriter.write(taiKhoanThanhToan.getId()+","+taiKhoanThanhToan.getMaTaiKhoan()+","+taiKhoanThanhToan.getTenChuTaiKhoan()+","+taiKhoanThanhToan.getNgayTaoTaiKhoan()+
                        ","+taiKhoanThanhToan.getSoThe()+","+taiKhoanThanhToan.getSoTienTrongTaiKhoan() +"\n");
        }

        bufferedWriter.close();
    }

}
