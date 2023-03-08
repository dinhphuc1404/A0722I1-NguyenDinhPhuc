package com.example.bai_tap_1.controller;

import com.example.bai_tap_1.entity.Calculator;
import com.example.bai_tap_1.service.CalculatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class CalculatorController {
    @Autowired
    private CalculatorServiceImpl calculatorService;

    @GetMapping("calculator/home")
    public String displayCalculator(){
        return "calculator/home";
    }
    @PostMapping("calculator/result")
    public String displayResult(@RequestParam double usd, @RequestParam double rate, Model model) {
        double result = calculatorService.convert(usd, rate);
        Calculator calculator = new Calculator(usd, rate, result);
        model.addAttribute("calculator", calculator);
        return "calculator/result";
    }
}
