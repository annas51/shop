package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.object.Cart;
import pl.britenet.campus.object.CartProduct;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartProductService {

    private final DatabaseService databaseService;

    public CartProductService (DatabaseService databaseService) {this.databaseService = databaseService;}

    public List<CartProduct> getCartProduct() {
        return this.databaseService.performSQL("SELECT * FROM cartProduct", resultSet -> {
            List<CartProduct> cartProductList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    CartProduct cartProduct = new CartProduct(resultSet.getInt("Id"));
                    cartProduct.setQuantity(resultSet.getInt("Quantity"));
                    cartProduct.setProductId(resultSet.getInt("ProductId"));
                    cartProductList.add(cartProduct);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return cartProductList;
        });
    }

    public Optional<CartProduct> getCartProduct(int id) {
        CartProduct retrievedCartProduct = this.databaseService.performSQL(String.format("SELECT * FROM cartProduct WHERE id = %d", id), resultSet -> {
            try {
                if (resultSet.next()) {
                    CartProduct cartProduct = new CartProduct(resultSet.getInt("Id"));
                    cartProduct.setQuantity(resultSet.getInt("quantity"));
                    cartProduct.setProductId(resultSet.getInt("ProductId"));
                    return cartProduct;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(retrievedCartProduct);
    }
}

