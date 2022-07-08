package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.object.Customer;
import pl.britenet.campus.object.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderService {

    private final DatabaseService databaseService;

    public OrderService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<Order> getOrder() {
        return this.databaseService.performSQL("SELECT * FROM product", resultSet -> {
            List<Order> orderList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    Order order = new Order(resultSet.getInt("id"));
                    order.setCreateAt(resultSet.getInt("Last_name"));
                    order.setProductId(resultSet.getInt("Address"));

                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return orderList;
        });
    }

    public Optional<Order> getOrder(int id) {
        Order retrievedOrder = this.databaseService.performSQL(String.format("SELECT * FROM product WHERE id = %d", id), resultSet -> {
            try {
                if (resultSet.next()) {
                    Order order = new Order(resultSet.getInt("id"));
                    order.setCreateAt(resultSet.getInt("Last_name"));
                    order.setProductId(resultSet.getInt("Address"));

                    return order;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(retrievedOrder);
    }

}

