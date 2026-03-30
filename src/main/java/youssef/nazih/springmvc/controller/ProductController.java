package youssef.nazih.springmvc.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import youssef.nazih.springmvc.entities.Product;
import youssef.nazih.springmvc.repository.ProductRepository;

import java.util.Objects;

@Controller
public class ProductController {
    @Autowired
    public ProductRepository productRepository;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("productList", productRepository.findAll());
        model.addAttribute("productToBeAdded", new Product());
        return "products";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/index";
    }

    @PostMapping("/save")
    public String add(@Valid Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("errorMessage", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            return "error";
        }
        productRepository.save(product);
        return "redirect:/index";
    }


    @GetMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @GetMapping("/newProduct")
    public String newProduct(Model model) {
        model.addAttribute("productToBeAdded", new Product());
        return "new-product";
    }

    @GetMapping("/update")
    public String updateProduct(Model model, @RequestParam(name = "id") Long id) {
        Product product = productRepository.findById(id).orElseThrow(RuntimeException::new);
        model.addAttribute("productToBeUpdated", product);
            return "update-product";
    }
}
