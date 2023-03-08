package com.example.bai_tap_2.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryServiceImpl implements IDictionaryService{
    private static Map<String, String> stringMap = new HashMap<>();

    static {
        stringMap.put("dog", "chó");
        stringMap.put("cat", "mèo");
        stringMap.put("tiger", "hổ");
        stringMap.put("lion", "sư tử");
        stringMap.put("fish", "cá");
    }


    @Override
    public String searchEng(String eng) {
        if(stringMap.containsKey(eng)){
            return stringMap.get(eng);
        }
        return "Không có trong từ điển";
    }
}
