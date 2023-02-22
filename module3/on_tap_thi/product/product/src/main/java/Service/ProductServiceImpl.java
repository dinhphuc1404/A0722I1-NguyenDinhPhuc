package Service;

import Model.Product;
import Repository.ProductRepository;
import util.Vali;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    ProductRepository productRepository= new ProductRepository();
    @Override
    public List<Product> getProductList() {
        return productRepository.getProductList();
    }

//    @Override
//    public void deleteProduct(int id) {
//
//
//
//    }
    public Boolean deleteProduct(int id){
        return productRepository.deleteProduct(id);
    }

    @Override
    public Integer getIdMax() {
        return  productRepository.getIdMax();
    }


    @Override
    public void save(Product product) {
        productRepository.save(product);


    }


    @Override
    public void updateProductId(Product product) {
        productRepository.updateProductId(product);


    }

    @Override
    public Product getProductId(int id) {
        return productRepository.getProductId(id);
    }

    @Override
    public List<Product> search(String name,String color) {
        return productRepository.search(name,color);
    }
}
