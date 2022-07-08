package pl.britenet.campus;

import pl.britenet.campus.getCommand.GetCartProductCommand;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.command.CommandService;
import pl.britenet.campus.command.HelloCommand;
import pl.britenet.campus.command.RetrieveProductsCommand;
import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.getCommand.GetCartCommand;
import pl.britenet.campus.getCommand.GetCustomerCommand;
import pl.britenet.campus.service.*;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isRunning = true;

        DatabaseService databaseService = new DatabaseService();
        ProductService productService = new ProductService(databaseService);
        CartService cartService = new CartService(databaseService);
        CartProductService cartProductService = new CartProductService(databaseService);
        OrderService orderService = new OrderService(databaseService);
        OrderProductService orderProductService = new OrderProductService(databaseService);








        CommandService commandService = new CommandService();
        commandService.registerCommand(new HelloCommand());
        commandService.registerCommand(new RetrieveProductsCommand(productService));
        commandService.registerCommand(new GetCartCommand(cartService));
        commandService.registerCommand(new GetCartProductCommand(cartProductService));
        commandService.registerCommand(new RetrieveProductsCommand(productService));
        commandService.registerCommand(new RetrieveProductsCommand(orderService));
        commandService.registerCommand(new GetCustomerCommand(CustomerService));

















        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("Wprowadź komendę...");
            String command = scanner.nextLine();
            Optional<Command> oCommand = commandService.getCommand(command);
            oCommand.orElseThrow().execute();
        }
    }
}
