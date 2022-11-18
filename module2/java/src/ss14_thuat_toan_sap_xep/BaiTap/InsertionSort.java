package ss14_thuat_toan_sap_xep.BaiTap;

public class InsertionSort {
    public static void sort(int myArr[]){
        for (int i=1;i<myArr.length;i++){
            int key = myArr[i];
            int j = i-1;
            while (j>=0&& myArr[j]>key){
                myArr[j+1] = myArr[j];
                j=j-1;
            }
            myArr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int [] list = {9,2,4,5,7,6,2,3,1,3,4};
        System.out.print("Mảng ban đầu: ");
        for (int j=0;j<list.length;j++){
            System.out.print(list[j]+" ");
        }
        System.out.print("\nMảng sau khi sắp xếp: ");
        sort(list);
        for (int i=0; i<list.length;i++){
            System.out.print(list[i]+" ");
        }
    }
}
