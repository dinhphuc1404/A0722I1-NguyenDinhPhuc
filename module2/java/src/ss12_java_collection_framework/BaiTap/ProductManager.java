package ss12_java_collection_framework.BaiTap;

import java.util.*;

public class ProductManager {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        List<Product> products= new ArrayList<>();
        products.add(new Product(1,"Tivi",2000000));
        products.add(new Product(2,"Tu lanh", 7000000));
        products.add(new Product(3,"May quat", 500000));
        productManager.display(products);
        productManager.add(products);
        productManager.edit(products);
        productManager.remove(products);
        productManager.search(products);


    }
    public void display(List<Product> products){
        for (int i=0;i<products.size();i++){
            System.out.println(products.get(i));
        }
    }
    public void add(List<Product> products){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào id: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println("Nhập vào tên: ");
        String name = input.nextLine();
        System.out.println("Nhập vào giá bán: ");
        double price = input.nextDouble();
        Product product = new Product(id,name,price);
        products.add(product);
        display(products);

    }
    public void edit(List<Product> products){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào id cần sửa thông tin: ");
        int inputID = Integer.parseInt(input.nextLine());
        boolean check = false;
        for (int i=0;i<products.size();i++){
            if(products.get(i).getId()==inputID){
                check=true;
                System.out.println("Nhập vào tên: ");
                String name = input.nextLine();
                System.out.println("Nhập vào giá bán: ");
                double price = input.nextDouble();
                products.set(i,new Product(inputID,name,price));
                display(products);
            }
        }
        if(!check){
            System.out.println("Không tìm thấy id");
        }
    }
    public void remove(List<Product> products){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào id muốn xóa: ");
        int inputID = Integer.parseInt(input.nextLine());
        boolean check = false;
        for (int i=0;i<products.size();i++){
            if(products.get(i).getId()==inputID){
                check=true;
                products.remove(i);
                display(products);
                break;
            }
        }
        if(!check){
            System.out.println("Không tìm thấy id");
        }
    }
    public void sort(List<Product> products){

    }
    public void search(List<Product> products) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên cần tìm kiếm :");
        String name = input.nextLine();
        Product producter = null;
        for (Product product : products){
            if (product.getName().equals(name)){
                producter = product;
                break;
            }
        }if (producter!=null){
            System.out.println("Sản phầm bạn tìm kiếm: "+producter);
        }else {
            System.out.println("Không có sản phẩm :" + name);
        }
    }
}
