package rest2.Cart;

public class CartError {
    private int statusCode;
    private String message;

    public CartError() {
    }

    public CartError(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
