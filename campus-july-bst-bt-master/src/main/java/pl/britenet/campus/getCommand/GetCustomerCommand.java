package pl.britenet.campus.getCommand;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.CartProduct;
import pl.britenet.campus.object.Customer;
import pl.britenet.campus.service.CartProductService;
import pl.britenet.campus.service.CustomerService;

import java.util.Optional;
import java.util.Scanner;

public class GetCustomerCommand extends Command {
    private final CustomerService customerService;

    public GetCustomerCommand(CustomerService customerService) {
        super(Constants.COMMAND_GET_CUSTOMER);
        this.customerService = customerService;


    }
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id:");
        String CustomerId = scanner.nextLine();
        Optional<Customer> customer = this.customerService.getCustomer(Integer.parseInt(CustomerId));
        customer.ifPresent(value ->
                System.out.println(String.valueOf(value.getCustomerId()) + ' ' +
                        String.valueOf(value.getName()) + ' ' + String.valueOf(value.getLast_name()) +
                                String.valueOf(value.getAddress()) + ' ' +
                        String.valueOf(value.getAddress())));


    }
}
