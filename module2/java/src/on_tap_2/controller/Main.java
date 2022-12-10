package on_tap_2.controller;

import on_tap_2.service.QuanLiDienThoai;

import java.util.Scanner;

public class Main {
    private static QuanLiDienThoai quanlidienthoai1= new QuanLiDienThoai();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choose;
        String input;
        String chon;
        do {
            System.out.println("1.Thêm Sản Phẩm");
            System.out.println("2. Hiển Thị ");
            System.out.println("3.Xóa ID");
            System.out.println("4.Tìm kiếm");
            System.out.println("5.Thoát");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Thêm mới");
                    System.out.println("Chọn 1:Thêm Mới Dien Thoai Chinh Hang");
                    System.out.println("Chọn 2: Thêm Mới Dien Thoai Xach Tay");
                    input = scanner.nextLine();
                    switch (input) {
                        case "1":
                            quanlidienthoai1.addNewChinhHang();
                            break;
                        case "2":
                            quanlidienthoai1.addnewXachtay();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Hiển Thị");
                    System.out.println("Chọn 1: Hiển Thị điện thoại chinh hãng");
                    System.out.println("Chọn 2: Hiển Thị điện thoại xách tay");
                    input = scanner.nextLine();
                    switch (input) {
                        case "1":
                            quanlidienthoai1.displayChinhHang();
                            break;
                        case "2":
                            quanlidienthoai1.displayXachtay();
                            break;
                    }
                    break;

                case 3:
                    System.out.println("Xóa");
                    System.out.println("Chọn 1:Xóa đt chinh hãng");
                    System.out.println("Chọn 2: Xóa đt xách tay");
                    input = scanner.nextLine();
                    switch (input) {
                        case "1": {
                            System.out.println("chọn yes or no ");
                            chon = scanner.nextLine();
                            switch (chon) {
                                case "yes":
                                    quanlidienthoai1.xoaChinhHang();
                                    break;
                                case "no":
                                    quanlidienthoai1.displayChinhHang();
                                    break;
                            }
                            break;
                        }
                        case "2":
                            System.out.println("chọn yes or no ");
                            chon = scanner.nextLine();
                            switch (chon) {
                                case "yes":
                                    System.out.println("Nhập id cần xóa");
                                    break;
                                case "no":
                                    quanlidienthoai1.displayXachtay();
                                    break;
                            }
                            break;
                    }
                    break;

                case 4:
                    System.out.println("Tìm Kiếm");
                    System.out.println(" 1.Tìm kiếm đt chinh hãng");
                    System.out.println(" 2. Tìm kiếm đt xách tay");
                    input = scanner.nextLine();
                    switch (input) {
                        case "1":
                            quanlidienthoai1.timkiemchinhhang();
                            break;
                        case "2":
                            quanlidienthoai1.timkiemXachTay();
                            break;
                    }
                    break;
                case 5:
                    return;

                default:
                    System.out.println("chọn sai");
                    break;
            }
        }
        while (choose != 5);
    }
}
