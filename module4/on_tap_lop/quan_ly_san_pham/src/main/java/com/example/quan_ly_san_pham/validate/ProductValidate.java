package com.example.quan_ly_san_pham.validate;

import com.example.quan_ly_san_pham.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.time.LocalDate;
@Component
public class ProductValidate implements Validator {
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
        Date now = Date.valueOf(LocalDate.now());
        System.out.println(now);
        if (product.getDate() == null){
            product.setDate(now);
        }
        if (product.getDate().before(now)) {
            errors.rejectValue("date", "create.date", "");
        }
    }
}
