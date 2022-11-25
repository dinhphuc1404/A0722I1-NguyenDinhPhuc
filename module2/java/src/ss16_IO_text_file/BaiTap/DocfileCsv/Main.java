package ss16_IO_text_file.BaiTap.DocfileCsv;

import sun.reflect.misc.FieldUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String FILE_PATH="E:\\Codegym\\6 module\\module2\\java\\src\\ss16_IO_text_file\\BaiTap\\DocfileCsv\\countries.csv";
    public static List<Country> readCSV() throws IOException {
        List<Country> countryList = new ArrayList<>();
        FileReader fileReader = new FileReader(FILE_PATH);
        BufferedReader buff = new BufferedReader(fileReader);

        String line;
        String[] temp;
        Country country;

        while ((line = buff.readLine()) != null){
            temp = line.split(",");
            int id = Integer.parseInt(temp[0]);
            String code = temp[1];
            String name = temp[2];

            country = new Country(id,code,name);
            countryList.add(country);
        }
        buff.close();
        return countryList;
    }

    public static void main(String[] args) throws IOException {
        List<Country> countryList= Main.readCSV();

        for (Country item: countryList){
            System.out.println(item);
        }
    }
}
