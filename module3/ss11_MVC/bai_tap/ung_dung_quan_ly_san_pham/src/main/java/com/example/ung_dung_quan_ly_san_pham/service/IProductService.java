package com.example.ung_dung_quan_ly_san_pham.service;

import com.example.ung_dung_quan_ly_san_pham.model.Product;

import java.util.List;

public interface IProductService {
        public List<Product> showAll();
        public void addNew(Product product);
        public boolean uppdate(Product product);
        public boolean delete(int id);
        public Product findById(int id);
}
