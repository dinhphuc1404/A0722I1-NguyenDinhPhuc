package ss16_IO_text_file.BaiTap.CopyFileText;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {
        public List<String>readFile(String filePath){
            List<String> stringList= new ArrayList<>();
            try {
                File file = new File(filePath);
                if(!file.exists()){
                    throw new FileNotFoundException();
                }
                BufferedReader reader= new BufferedReader(new FileReader(file));
                String line = null;
                while ((line=reader.readLine())!=null){
                    stringList.add(line);

                }
                reader.close();
            } catch (Exception e){
                e.printStackTrace();
            }
            return stringList;

        }
    public void copyFile (String filePath,List<String>str){
        try {
            File file= new File(filePath);
            BufferedWriter writer= new BufferedWriter(new FileWriter(file));
            for(String line:str){
                writer.write(line);
                writer.newLine();

            }
            writer.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CopyFileText copyFileText = new CopyFileText();
        List<String> string = copyFileText.readFile("E:\\Codegym\\6 module\\module2\\java\\src\\ss16_IO_text_file\\BaiTap\\CopyFileText\\phuc.txt");
        copyFileText.copyFile("E:\\Codegym\\6 module\\module2\\java\\src\\ss16_IO_text_file\\BaiTap\\CopyFileText\\coppy.txt",string);
    }

}
