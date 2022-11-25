package ss16_IO_text_file.ThucHanh;

import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public void readFileText(String filePath){
        try {
            //đọc theo đường dẫn
            File file = new File(filePath);
            //kiểm tra nếu file ko tồn tại thì ném ngoại lệ
            if(!file.exists()){
                throw new FileNotFoundException();
            }
            //đọc từng dòng của file và tiến hành cộng tổng lại
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = " ";
            int sum =0;
            while ((line=br.readLine())!= null){
                System.out.println(line);
                sum+=Integer.parseInt(line);
            }
            br.close();
            // hiển thị ra màn hình tổng số nguyên trong file
            System.out.println("Tổng = "+sum);
        }catch (Exception e){
            //trường hơp file ko tồn tại hoặc lỗi
            System.out.println("File không tồn tại");
        }
    }

    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner input = new Scanner(System.in);
        String path = input.nextLine();
        ReadFileExample readFileExample = new ReadFileExample();
        readFileExample.readFileText(path);
    }
}
