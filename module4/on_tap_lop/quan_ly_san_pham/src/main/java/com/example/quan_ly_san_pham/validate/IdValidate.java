package com.example.quan_ly_san_pham.validate;

import com.example.quan_ly_san_pham.entity.Product;
import com.example.quan_ly_san_pham.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class IdValidate implements Validator {
    @Autowired
    ProductService service;
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Product)) {
            return;
        }
        Product product = (Product) target;
        if (service.findById(product.getId()) != null) {
            errors.rejectValue("id", "create.duplicateId", new String[]{product.getId()},"ID bị trùng lặp");
        }

    }
}
