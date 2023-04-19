package com.example.student.validate;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class StudentValidate implements Validator {
    @Autowired
    private StudentService service;

    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Student)) {
            return;
        }
        Student student = (Student) target;
        if (service.findById(student.getId()) != null) {
            errors.rejectValue("id", "create.duplicateId", new String[]{student.getId()}, "ID bị trùng lặp");
        }
//        if ((student.getBirthdate()!=null && student.getBirthdate().before(new Date()))){
//            errors.rejectValue("birthdate","birthdate","Vui lòng nhập ngày tương lai");
//        }

        if (student.getPhoneNumber().length() != 10) {
            errors.rejectValue("phoneNumber", "phonenumber", new String[]{"10"}, "Số điện thoại không đúng định dạng");
        } else if (!student.getPhoneNumber().startsWith("0")) {
            errors.rejectValue("phoneNumber", "phonenumberstart", "Số điện thoại không đúng định dạng");
        }
    }

    public StudentService getService() {
        return service;
    }

    public void setService(StudentService service) {
        this.service = service;
    }
}

