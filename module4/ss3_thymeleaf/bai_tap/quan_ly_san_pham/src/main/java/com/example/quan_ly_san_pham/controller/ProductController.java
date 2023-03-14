package com.example.quan_ly_san_pham.controller;

import com.example.quan_ly_san_pham.entity.Product;
import com.example.quan_ly_san_pham.repository.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/","/product"})
public class ProductController {
    @Autowired
    ProductRepositories productRepositories;
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("customerList",productRepositories.findAll());
        return "index";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("product",productRepositories.findById(id));
        return "view";
    }
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("product",productRepositories.findById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(Product product){
        productRepositories.update(product);
        return "redirect:/product/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("product",productRepositories.findById(id));
        productRepositories.remove(id);
        return "redirect:/product/";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/create")
    public String create(Product product){
        productRepositories.save(product);
        return "redirect:/product/";
    }
}