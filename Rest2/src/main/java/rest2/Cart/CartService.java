package rest2.Cart;

import org.springframework.stereotype.Service;
import rest2.Product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@Scope("singleton")
public class CartService {


    private static CartService instance;
    private final List<Product> cart;

    private CartService() {
        cart = new ArrayList<>();
    }


    public static CartService getInstance() {
        if (instance == null) {
            instance = new CartService();
        }
        return instance;
    }



    public List<Product> findAll() {
        return cart;
    }

    public Optional<Product> findById(long id) {
         return  cart.stream().filter(p -> p.getId() == id).findFirst();
    }

    public Product save(Product product) {
        cart.add(product);

        return product;
    }

    @Override
    public String toString() {
        return "CartService{" +
                "cart=" + cart +
                '}';
    }
}
