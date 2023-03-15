package com.example.form_to_khai_y_te.controller;

import com.example.form_to_khai_y_te.entity.Customer;
import com.example.form_to_khai_y_te.service.CustomerService;
import com.example.form_to_khai_y_te.service.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    private CustomerService customerService=new CustomerServiceImpl();
    @GetMapping(value = "/home")
    public  String home(Model model){
        model.addAttribute("customer",new Customer());
        return "home";
    }

    @PostMapping(value = "/save")
    public ModelAndView save(@ModelAttribute Customer customer){
        customerService.save(customer);
        List<Customer> customerList=customerService.display();;
        ModelAndView modelAndView= new ModelAndView("save","list",customerList);
        return modelAndView;

    }


}