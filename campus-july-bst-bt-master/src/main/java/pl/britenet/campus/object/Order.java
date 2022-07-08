package pl.britenet.campus.object;

import pl.britenet.campus.Constants;

public class Order {
    private int orderId;
    private int createAt;
    private int productId;
    public Order(int OrderId) {
        this.orderId = OrderId;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCreateAt() {
        return createAt;
    }

    public void setCreateAt(int createAt) {
        this.createAt = createAt;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
