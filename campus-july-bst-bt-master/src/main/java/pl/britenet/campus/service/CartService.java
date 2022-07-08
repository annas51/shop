package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.object.Cart;
import pl.britenet.campus.object.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartService {

    private final DatabaseService databaseService;

    public CartService (DatabaseService databaseService) {this.databaseService = databaseService;}

    public List<Cart> getCart() {
        return this.databaseService.performSQL("SELECT * FROM cart", resultSet -> {
            List<Cart> cartList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    Cart cart = new Cart(resultSet.getInt("Id"));
                    cart.setTotal(resultSet.getInt("Total"));
                    cart.setProductId(resultSet.getInt("ProductId"));
                    cart.setCustomerId(resultSet.getInt("CustomerId"));
                    cartList.add(cart);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return cartList;
        });
    }

    public Optional<Cart> getCart(int id) {
        Cart retrievedCart = this.databaseService.performSQL(String.format("SELECT * FROM cart WHERE id = %d", id), resultSet -> {
            try {
                if (resultSet.next()) {
                    Cart cart = new Cart(resultSet.getInt("id"));
                    cart.setTotal(resultSet.getInt("Total"));
                    cart.setProductId(resultSet.getInt("ProductId"));
                    cart.setCustomerId(resultSet.getInt("CustomerId"));
                    return cart;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(retrievedCart);
    }
}
