package Service;

import Model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    public List<Product> getProductList();
//    public void deleteProduct(int id);
    Boolean deleteProduct(int id);
    public Integer getIdMax();
    public void save(Product product);
//   Map<String, String> save(Product product);
    public void updateProductId(Product product);
    public Product getProductId(int id);
    public List<Product> search(String name,String color);
}
