package rest2.Cart;

import rest2.Product.Product;

import java.util.List;


public class Cart {

    private int id;
    private String userName;
    private List<Product> product;


    public Cart() {
    }

    public Cart(String userName) {
        this.userName = userName;
    }

    public Cart(String userName, List<Product> product) {
        this.userName = userName;
        this.product = product;
    }

    public Cart(int id, String userName, List<Product> product) {
        this.id = id;
        this.userName = userName;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", product=" + product +
                '}';
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public List<Product> getProduct() {
        return product;
    }


}
