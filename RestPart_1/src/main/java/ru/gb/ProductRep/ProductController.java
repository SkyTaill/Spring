package ru.gb.ProductRep;


import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

@GetMapping
    public List<Product> list(){
        return productService.findAll();
}
@GetMapping("{id}")
    public Optional<Product> findById(@PathVariable long id){
        return productService.findById(id);
}

@PostMapping
    public Product add(@RequestBody Product product){
        System.out.println(product);
       Product productLocal= productService.save(product);
        return productLocal;
}




}
