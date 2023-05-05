package com.example.quan_ly_san_pham.service;

import com.example.quan_ly_san_pham.entity.Product;
import com.example.quan_ly_san_pham.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Product> findAllWithPaging(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Slice<Product> findAllWithSlice(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> findAllByIdAndName(String id, String name, Pageable pageable) {
        return productRepository.findAllByIdContainingAndNameContaining(id, name, pageable);
    }

    @Override
    public void deleteAll(String[] ids) {
        productRepository.deleteAllByIdIn(ids);
    }

    @Override
    public Slice<Product> findAllBySearchAll(String id, String name, Pageable pageable) {
        return productRepository.findAllByIdContainsOrNameContains(id,name,pageable);
    }
}
