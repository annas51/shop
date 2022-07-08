package pl.britenet.campus.object;

public class OrderProduct {
    private int OrderProductId;
    private int ProductId;

    public OrderProduct(int OrderId) {
        this.OrderProductId = OrderId;
    }


    public int getOrderProductId() {
        return OrderProductId;
    }

    public void setOrderProductId(int orderProductId) {
        OrderProductId = orderProductId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }
}
