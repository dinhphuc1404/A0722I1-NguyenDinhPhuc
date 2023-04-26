package com.example.quang_ly_phong_tro.fomatter;

import com.example.quang_ly_phong_tro.entity.MotelRoom;
import com.example.quang_ly_phong_tro.service.MotelRoomService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class MotelRoomFormatter  implements Formatter<MotelRoom> {
    private MotelRoomService service;
    @Override
    public MotelRoom parse(String text, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(MotelRoom object, Locale locale) {
        return object.toString();
    }
}
