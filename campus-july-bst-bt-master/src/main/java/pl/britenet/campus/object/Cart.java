package pl.britenet.campus.object;

import pl.britenet.campus.Constants;

public class Cart {
    private int cartId;
    private int total;
    private int productId;
    private int customerId;

    public Cart() {
        this.cartId = Constants.INVALID_ID;
    }

    public Cart(int cartId) {
        this.cartId = cartId;
    }

    public int getCartId() {
        return cartId;
    }


    public float getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

}





