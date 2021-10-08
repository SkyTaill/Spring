package ru.gb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.gb.domain.Product;
import ru.gb.repository.ProductRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;

    }


    @GetMapping
    public String findAll2(Model model) {
        List<Product> products = new ArrayList<>();
        repository.findAll().forEach(products::add);
        model.addAttribute("products", products);

        return "products";
    }

    @GetMapping("/add")
    public String saveForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-add";
    }

    @PostMapping("/add")
    public String save(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product-add";
        }

        repository.save(product);
        return "product-add";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Product findById(@PathVariable int id) {
        return repository.findById(id).orElseThrow();
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        repository.deleteById(id);


    }


}
