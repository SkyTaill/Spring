package rest2.Cart;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest2.Product.Product;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController

@RequestMapping("carts")
public class CartController {
    private final CartService cartRepository;


    public CartController() {
        this.cartRepository =  CartService.getInstance();


    }


    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(cartRepository.findAll());

    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) {
        Optional<Product> cartRepositoryById = cartRepository.findById(id);
        if (cartRepositoryById.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cartRepositoryById.get());
    }


    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product newlyCreated = cartRepository.save(product);
        return ResponseEntity.created(URI.create("/departments/" + newlyCreated.getId())).body(newlyCreated);
    }

    @ExceptionHandler
    public ResponseEntity<CartError> handleException(RuntimeException ex) {
        return ResponseEntity.internalServerError()
                .body(new CartError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
    }


}

