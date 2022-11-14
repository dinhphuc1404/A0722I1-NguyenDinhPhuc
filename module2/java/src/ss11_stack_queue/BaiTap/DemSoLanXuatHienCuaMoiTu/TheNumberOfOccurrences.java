package ss11_stack_queue.BaiTap.DemSoLanXuatHienCuaMoiTu;

import java.util.*;

public class TheNumberOfOccurrences {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        System.out.println("Nhập chuỗi");
        String str = input.nextLine() ;
        String[] arrStr = str.split(" ");
        System.out.println(Arrays.toString(arrStr));

        for (int i = 0; i < arrStr.length; i++) {
            String arrKey = arrStr[i].toUpperCase();
            System.out.println(arrKey);

            if (map.containsKey(arrKey)) {
                //day key vao map xong tăng lên 1
                map.put(arrKey, map.get(arrKey) + 1);
            } else {
                map.put(arrKey, 1);
            }
        }
        System.out.println(map.toString());

    }

}

