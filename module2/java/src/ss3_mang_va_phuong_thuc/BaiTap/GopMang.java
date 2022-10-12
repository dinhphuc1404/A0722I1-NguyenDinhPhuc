package ss3_mang_va_phuong_thuc.BaiTap;
import java.util.Arrays;

public class GopMang {
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4};
        int arr2[] = {5,6,7};
        int merge[] = new int[arr1.length+arr2.length];
        System.arraycopy(arr1, 0,merge,0, arr1.length);
        System.arraycopy(arr2,0,merge,arr1.length,arr2.length);
        System.out.println(Arrays.toString(merge));
    }
}
