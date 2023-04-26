package com.example.quang_ly_phong_tro.validate;


import com.example.quang_ly_phong_tro.entity.MotelRoom;
import com.example.quang_ly_phong_tro.service.MotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class MotelRoomValidate implements Validator {
    @Autowired
    private MotelRoomService service;
    @Override
    public boolean supports(Class<?> clazz) {
        return MotelRoom.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(!(target instanceof  MotelRoom)){
            return;
        }
        MotelRoom motelRoom = (MotelRoom) target;
        if (motelRoom.getPhoneNumber().length() != 10) {
            errors.rejectValue("phoneNumber", "phonenumber", new String[]{"10"}, "Số điện thoại không đúng định dạng");
        } else if (!motelRoom.getPhoneNumber().startsWith("0")) {
            errors.rejectValue("phoneNumber", "phonenumberstart", "Số điện thoại không đúng định dạng");
        }
    }
}
