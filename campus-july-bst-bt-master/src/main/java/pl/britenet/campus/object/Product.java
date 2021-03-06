package pl.britenet.campus.object;

import pl.britenet.campus.Constants;

public class Product {
    private final int productId;
    private String name;
    private String description;
    private double price;
    private int quantity;

    public Product(){
        this.productId = Constants.INVALID_ID;
    }

    public Product(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
