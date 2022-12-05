package ss17_IOFileBnary.BaiTap;

import java.io.*;
import java.util.List;

public class ReadAndWriteFile {
    public static void write(List<Product> collection, String filePath){
        File file= new File(filePath);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fileOutputStream= null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream= new ObjectOutputStream(fileOutputStream);
//hứng dữ liệu khi ghi vào file
            objectOutputStream.writeObject(collection);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //đọc file có kiểu trả về là obj, chỉ cần truyền 1 tham số là địa chỉ
    public static Object readFile(String filePath){
        FileInputStream fileInputStream= null;
        ObjectInputStream objectInputStream= null;
        //luu ý//
        Object object= null;
        try {
            fileInputStream= new FileInputStream(filePath);
            objectInputStream= new ObjectInputStream(fileInputStream);
            object=objectInputStream.readObject();
            return object;

        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;


    }
}
