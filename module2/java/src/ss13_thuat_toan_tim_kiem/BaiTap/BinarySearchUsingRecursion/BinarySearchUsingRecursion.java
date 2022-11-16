package ss13_thuat_toan_tim_kiem.BaiTap.BinarySearchUsingRecursion;

public class BinarySearchUsingRecursion {
    public static int binarySearch(int[] array, int left, int right ,int value){
        if(right>=left){
            int middle =(left+right)/2;
            if(value==array[middle]){
                return middle;
            }else if(value<array[middle]){
                return binarySearch(array,left,middle-1,value);
            } else {
                return binarySearch(array,middle+1,right,value);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchUsingRecursion ob = new BinarySearchUsingRecursion();
         int[] array = {2,6,7,9,10,11,20,25,36,45,74};
        int n = array.length;
        int x = 74;
        int result = ob.binarySearch(array,0,n-1,x);
        if(result==-1){
            System.out.println("Not found");
        }else {
            System.out.println("Element found at index "+result);
        }
    }
}
