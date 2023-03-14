package com.example.hom_thu_dien_tu.entity;

import java.util.ArrayList;
import java.util.List;

public class ListLanguages {
    public static List<String> languages(){
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        return languages;
    }
}
