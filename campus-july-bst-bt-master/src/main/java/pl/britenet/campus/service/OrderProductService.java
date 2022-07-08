package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.object.OrderProduct;
import pl.britenet.campus.object.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderProductService {

    private final DatabaseService databaseService;

    public OrderProductService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<OrderProduct> getOrderProduct() {
        return this.databaseService.performSQL("SELECT * FROM product", resultSet -> {
            List<OrderProduct> OrderProductList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    OrderProduct orderProduct = new OrderProduct(resultSet.getInt("id"));
                    orderProduct.setProductId(resultSet.getInt("ProductId"));
                    OrderProductList.add(orderProduct);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return OrderProductList;
        });
    }

    public Optional<OrderProduct> getOrderProduct(int id) {
        OrderProduct retrievedOrderProduct = this.databaseService.performSQL(String.format("SELECT * FROM product WHERE id = %d", id), resultSet -> {
            try {
                if (resultSet.next()) {
                    OrderProduct orderProduct = new OrderProduct(resultSet.getInt("id"));
                    orderProduct.setProductId(resultSet.getInt("Product Id"));
                    return orderProduct;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(retrievedOrderProduct);
    }
}

