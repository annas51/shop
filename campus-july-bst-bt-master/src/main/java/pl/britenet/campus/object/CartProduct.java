package pl.britenet.campus.object;


import pl.britenet.campus.Constants;

public class CartProduct {
    private int cartProductId;

    private int quantity;

    private int ProductId;
    public CartProduct(int databaseService) {
        this.cartProductId = Constants.INVALID_ID;
    }


    public int getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(int cartProductId) {
        this.cartProductId = cartProductId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }
}
