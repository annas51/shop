package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.object.Customer;
import pl.britenet.campus.object.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerService {

    private final DatabaseService databaseService;

    public CustomerService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<Customer> getCustomer() {
        return this.databaseService.performSQL("SELECT * FROM Customer", resultSet -> {
            List<Customer> customerList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    Customer customer = new Customer(resultSet.getInt("id"));
                    customer.setName(resultSet.getString("name"));
                    customer.setLast_name(resultSet.getString("Last_name"));
                    customer.setAddress(resultSet.getString("Address"));
                    customer.setPhone_nr(resultSet.getString("Phone_nr "));

                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return customerList;
        });
    }

    public Optional<Customer> getCustomer(int id) {
        Customer retrievedCustomer = this.databaseService.performSQL(String.format("SELECT * FROM product WHERE id = %d", id), resultSet -> {
            try {
                if (resultSet.next()) {
                    Customer customer = new Customer(resultSet.getInt("id"));
                    customer.setName(resultSet.getString("name"));
                    customer.setLast_name(resultSet.getString("Last_name"));
                    customer.setAddress(resultSet.getString("Address"));
                    customer.setPhone_nr(resultSet.getString("Phone_nr "));

                    return customer;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(retrievedCustomer);
    }

}
