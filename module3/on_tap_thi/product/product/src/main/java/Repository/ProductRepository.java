package Repository;

import Model.Product;
import util.Vali;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    private BaseRepository baseRepository = new BaseRepository();

    public List<Product> getProductList() {

        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement ps = this.baseRepository.getConnection().prepareStatement("SELECT * from product");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                productList.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;

    }

    public Boolean save(Product product) {
        try {
            PreparedStatement ps = this.baseRepository.getConnection().prepareStatement("INSERT INTO Product VALUES (?, ? ,?, ?, ?, ?, ?)");
            ps.setInt(1, product.getId_product());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getGia());
            ps.setInt(4, product.getSoLuong());
            ps.setString(5, product.getColor());
            ps.setString(6, product.getMoTa());
            ps.setInt(7, product.getId_category());


            int check = ps.executeUpdate();
            if (check != 0) {
                return true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }




    public Integer getIdMax() {
        int id = 0;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("SELECT Max(id_product) FROM product");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public Boolean deleteProduct(int id) {
        try {
            PreparedStatement ps = this.baseRepository.getConnection().prepareStatement("Delete FROM product where id_product = ?");
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;


    }

    public void updateProductId(Product product) {
        try {
            PreparedStatement ps = this.baseRepository.getConnection().prepareStatement(
                    "UPDATE product SET ten_san_pham = ? , gia  = ?  , so_luong = ? , mau_sac = ? , mo_ta = ? , id_category = ? WHERE id_product = ?");
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getGia());
            ps.setInt(3, product.getSoLuong());
            ps.setString(4, product.getColor());
            ps.setString(5, product.getMoTa());
            ps.setInt(6, product.getId_category());
            ps.setInt(7, product.getId_product());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("lỗi rồi a ơiii");
            e.printStackTrace();

        }
    }

    public Product getProductId(int id) {
        Product product = new Product();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(" SELECT * FROM product WHere id_product = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                product = (new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<Product> search(String name, String color) {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement ps = this.baseRepository.getConnection().prepareStatement("select * from product where ten_san_pham like ? and mau_sac like ? ");
            ps.setString(1, "%" + name + "%");
            ps.setString(2, "%" + color + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                productList.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;

    }


    public static void main(String[] args) {
        List<Product> list = new ProductRepository().getProductList();
        for (Product p : list
        ) {
            System.out.println(p);
        }
    }

}
