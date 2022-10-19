package ss2_vong_lap;

public class HienThiCacSoNguyenToNhoHonMotTram {
    public static void main(String[] args) {
        int count = 0;
        int num =2;
        int n = 100;
        System.out.println("Các số nguyên tố nhỏ hơn 100");
        while (count<n){
            boolean check = true;
            for (int i =2;i<Math.sqrt(num);i++){
                if(num%i==0){
                    check = false;
                    break;
                }
            }
            if(check){
                System.out.print(num+" ");
                count++;
            }
            num++;
        }
    }
}
