package codegym.vn.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {
    @GetMapping("/role/index")
    public String role(Model model, HttpServletRequest request) {
        model.addAttribute("user", request.getUserPrincipal().getName());
        return "role";
    }
    @GetMapping("/admin/index")
    public String admin() {
        return "admin";
    }

    @GetMapping("/deny")
    public String deny() {
        return "accessdeny";
    }
}
