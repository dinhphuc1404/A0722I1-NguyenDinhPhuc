package codegym.controller;

import codegym.entity.Blog;
import codegym.service.BlogService;
import codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
    /**
     * List
     */
    @GetMapping("")
    public String listPageSort(@RequestParam("page") Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size,
//                               @RequestParam("sort") Optional<String> sort,
                               Model model) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Sort sort = Sort.by("blogName").ascending();
        Page<Blog> blogs = blogService.getPageBlog(PageRequest.of(currentPage - 1, pageSize, sort));
        model.addAttribute("blogs", blogs);
        return "/blog/listPaging";
    }

    /**
     * search
     */
    @GetMapping("/search")
    public String searchPageAll(@RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size,
                                @RequestParam String search,
                                Model model) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Sort sort = Sort.by("blogName").ascending();
        model.addAttribute("search", search);
        Page<Blog> blogPage = blogService.searchAllPage(search,PageRequest.of(currentPage - 1, pageSize, sort));
        model.addAttribute("blogs", blogPage);
        return "/blog/listPaging";
    }


    /**
     * create
     */
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categorys", categoryService.findAll());
        return "/blog/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute Blog blog, Model model, RedirectAttributes rd) {
        model.addAttribute("categorys", categoryService.findAll());
        blogService.create(blog);
        rd.addFlashAttribute("message", "Create new successfully!");
        return "redirect:/blog";
    }

    /**
     * update
     */
    @GetMapping("/update")
    public String showUpdateForm(@RequestParam Long blogId, Model model) {
        model.addAttribute("blog", blogService.findById(blogId));
        // Entity 2nd
        model.addAttribute("categorys", categoryService.findAll());
        return "/blog/update";
    }

    @PostMapping("update")
    public String doUpdate(@ModelAttribute Blog blog,
                           Model model, RedirectAttributes rd) {
        //phan nay voi create giong nhau
        model.addAttribute("categorys", categoryService.findAll());
        blogService.update(blog);
        rd.addFlashAttribute("message", "update successfully!");
        return "redirect:/blog";
    }
    /**
     * View
     */
    @GetMapping("/view")
    public String showViewForm(@RequestParam Long blogId, Long categoryId, Model model) {
        model.addAttribute("blog", blogService.findById(blogId));
        return "/blog/view";
    }

    /**
     * Delete all
     */
    @PostMapping("/delete")
    public String doDeleteAll(@RequestParam("checkbox") long[] checkbox, Model model, RedirectAttributes redirect) {
        for (long no : checkbox) {
            blogService.delete(no);
            redirect.addFlashAttribute("message", "Removed successfully!");
        }
        return "redirect:/blog";
    }

    /**
     * List
     */
    @GetMapping("/list")
    public String displayList(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "/blog/list";
    }


}
