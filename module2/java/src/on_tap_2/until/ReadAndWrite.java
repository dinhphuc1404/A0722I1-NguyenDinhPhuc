package on_tap_2.until;

import on_tap_2.model.DienThoaiChinhHang;
import on_tap_2.model.DienThoaiXachTay;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    final static String MOBILE_CH = "E:\\Codegym\\6 module\\module2\\java\\src\\on_tap_2\\until\\dienthoaichinhhang.csv";
    final static String MOBILE_XT = "E:\\Codegym\\6 module\\module2\\java\\src\\on_tap_2\\until\\dienthoaixachtay.csv";

    public static void writemobileCH(List<DienThoaiChinhHang> dienthoaichinhhangList, boolean append) {
        File file = new File(MOBILE_CH);

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (DienThoaiChinhHang o : dienthoaichinhhangList) {
                bufferedWriter.write(o.getToCv());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static void writemobileXT(List<DienThoaiXachTay> dienthoaixachtayList, boolean append) {
        File file = new File(MOBILE_XT);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (DienThoaiXachTay o : dienthoaixachtayList) {
                bufferedWriter.write(o.getToCv());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static List<DienThoaiChinhHang> readmobileCH() {
        List<DienThoaiChinhHang> dienthoaichinhhangList = new ArrayList<>();
        File file = new File(MOBILE_CH);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line = null;
            String[] array = null;

            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                DienThoaiChinhHang dienthoaichinhhang1 = new DienThoaiChinhHang(Integer.parseInt(array[0]), array[1],
                        Integer.parseInt(array[2]), Integer.parseInt(array[3]), array[4], Integer.parseInt(array[5]), array[6]);
                dienthoaichinhhangList.add(dienthoaichinhhang1);
            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            e.getStackTrace();
        }
        return dienthoaichinhhangList;
    }

    public static List<DienThoaiXachTay> readmobileXT() {
        List<DienThoaiXachTay> dienthoaixachtayList = new ArrayList<>();
        File file = new File(MOBILE_XT);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            String[] array = null;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                DienThoaiXachTay dienthoaixachtay1 = new DienThoaiXachTay(Integer.parseInt(array[0]), array[1],
                        Integer.parseInt(array[2]), Integer.parseInt(array[3]), array[4], (array[5]), array[6]);
                dienthoaixachtayList.add(dienthoaixachtay1);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
        return dienthoaixachtayList;
    }
}
