package youssef.nazih.springmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import youssef.nazih.springmvc.repository.ProductRepository;

@Controller
public class ProductController {
    @Autowired
    public ProductRepository productRepository;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("productList", productRepository.findAll());
        return "products";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/index";
    }


}
