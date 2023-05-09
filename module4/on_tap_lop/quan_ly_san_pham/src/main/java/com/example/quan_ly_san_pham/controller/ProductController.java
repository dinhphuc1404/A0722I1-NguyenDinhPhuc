package com.example.quan_ly_san_pham.controller;

import com.example.quan_ly_san_pham.entity.Category;
import com.example.quan_ly_san_pham.entity.Product;
import com.example.quan_ly_san_pham.service.CategoryService;
import com.example.quan_ly_san_pham.service.ProductService;
import com.example.quan_ly_san_pham.validate.IdValidate;
import com.example.quan_ly_san_pham.validate.ProductValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private IdValidate validate;

    @Autowired
    private ProductValidate productValidate;

    @GetMapping("/list")
    public String listpagingslice(Model model, @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Slice<Product> products = productService.findAllWithSlice(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("products", products.getContent());
        model.addAttribute("page", products);
        return "product/list";
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        List<Category> categories = categoryService.findAll();
        Product product = new Product();
        product.setCategory(new Category());
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "/product/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("product") Product product,
                         BindingResult bindingResult, Model model) {
        validate.validate(product,bindingResult);
        productValidate.validate(product,bindingResult);
        if (bindingResult.hasErrors()) {
            List<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            if (product.getCategory() == null) {
                product.setCategory(new Category());
            }
            return "/product/create";
        }
        productService.create(product);
        return "redirect:/product/list";
    }

    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Product product, Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("product", product);
        return "/product/update";
    }

    @PostMapping("/update")
    public String update(@Valid@ModelAttribute("product")  Product product,BindingResult bindingResult,Model model){
        productValidate.validate(product,bindingResult);
        if (bindingResult.hasErrors()) {


            List<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            if (product.getCategory() == null) {
                product.setCategory(new Category());
            }
            return "/product/update";
        }
        productService.update(product);
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        productService.delete(id);
        return "redirect:/product/list";
    }

    @GetMapping( "/search")
    public String search(@RequestParam("page") Optional<Integer> page,
                         @RequestParam("size") Optional<Integer> size, @RequestParam("searchAll") String searchAll , Model model ) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        model.addAttribute("searchAll", searchAll);
        Slice<Product> products = productService.findAllBySearchAll( searchAll, searchAll,PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("products", products.getContent());
        model.addAttribute("page", products);
        return "product/list";
    }

    @GetMapping(value = "/deleteAll")
    public String delete(@RequestParam("ids") String[] ids) {
        productService.deleteAll(ids);
        return "redirect:/product/list";
    }
}
