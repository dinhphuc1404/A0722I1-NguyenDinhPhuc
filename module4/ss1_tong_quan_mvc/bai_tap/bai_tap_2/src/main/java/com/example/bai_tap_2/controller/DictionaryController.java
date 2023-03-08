package com.example.bai_tap_2.controller;

import com.example.bai_tap_2.entity.Search;
import com.example.bai_tap_2.service.DictionaryServiceImpl;
import com.example.bai_tap_2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryServiceImpl dictionaryService;

    @GetMapping("dictionary")
    public String displayTrans() {
        return "dictionary";
    }
    @PostMapping("/dictionary")
    public String displayResult(@RequestParam String dictionary , Model model){
        String result = dictionaryService.searchEng(dictionary);
        Search searchWord = new Search(dictionary,result);
        model.addAttribute("searchWord",searchWord);
        return "dictionary";
    }
}
