package Repository;

import Model.Category;
import Model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private BaseRepository baseRepository = new BaseRepository();
    public List<Category> getListCategory() {

        List<Category> categoryList = new ArrayList<>();
        try {
            PreparedStatement ps = this.baseRepository.getConnection().prepareStatement("select * from category;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                categoryList.add(new Category(rs.getInt(1),
//                        rs.getString(2)));
                int id_category = rs.getInt("id_category"); // colummLable : tên  thuocj tính của bảng
                String ten_danh_muc  = rs.getString("ten_danh_muc");

                Category category = new Category(id_category,ten_danh_muc);
                categoryList.add(category);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;

    }

}
