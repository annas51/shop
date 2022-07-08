package pl.britenet.campus.getCommand;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.CartProduct;
import pl.britenet.campus.service.CartProductService;


import java.util.Optional;
import java.util.Scanner;

public class GetCartProductCommand extends Command {
    private final CartProductService cartProductService;

    public GetCartProductCommand(CartProductService cartProductService) {
        super(Constants.COMMAND_GET_CART_PRODUCT);
        this.cartProductService = cartProductService;


    }
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id:");
        String CartProductId = scanner.nextLine();
        Optional<CartProduct> cart = this.cartProductService.getCartProduct(Integer.parseInt(CartProductId));
        cart.ifPresent(value ->
                System.out.println(String.valueOf(value.getCartProductId()) + ' ' +
                        String.valueOf(value.getQuantity()) + ' ' +
                        String.valueOf(value.getProductId())));


    }
}

