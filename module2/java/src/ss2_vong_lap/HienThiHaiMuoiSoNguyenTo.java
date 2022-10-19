package ss2_vong_lap;

public class HienThiHaiMuoiSoNguyenTo {
    public static void main(String[] args) {
        int number = 2;
        int count = 0;
        System.out.println("20 số nguyên tố đầu tiên: ");
        while (count<20){
            int i =2;
            boolean check = true;
            while (i<number){
                if(number%i==0){
                    check = false;
                    break;
                }
                i++;
            }
            if(check){
                System.out.print(number+" ");
                count++;
            }
            number++;
        }
    }
}
