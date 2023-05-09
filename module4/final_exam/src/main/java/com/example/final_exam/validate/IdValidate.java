package com.example.final_exam.validate;

import com.example.final_exam.entity.DuAn;
import com.example.final_exam.service.DuAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class IdValidate implements Validator {
    @Autowired
    DuAnService service;
    @Override
    public boolean supports(Class<?> clazz) {
        return DuAn.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof DuAn)) {
            return;
        }
        DuAn duAn = (DuAn) target;
        if (service.findById(duAn.getMaDuAn()) != null) {
            errors.rejectValue("maDuAn", "create.duplicateId", new String[]{duAn.getMaDuAn()},"ID bị trùng lặp");
        }

    }
}
