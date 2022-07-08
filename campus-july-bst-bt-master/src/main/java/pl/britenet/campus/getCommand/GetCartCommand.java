package pl.britenet.campus.getCommand;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Cart;
import pl.britenet.campus.service.CartService;

import java.util.Optional;
import java.util.Scanner;

public class GetCartCommand extends Command {
    private final CartService cartService;

    public GetCartCommand(CartService cartService) {
        super(Constants.COMMAND_GET_CART);
        this.cartService = cartService;


    }
public void execute() {
        Scanner scanner = new Scanner(System.in);
    System.out.println("Enter id:");
    String CartId = scanner.nextLine();
    Optional<Cart> cart = this.cartService.getCart(Integer.parseInt(CartId));
    cart.ifPresent(value ->
            System.out.println(String.valueOf(value.getCartId()) + ' ' +
                    String.valueOf(value.getTotal()) + ' ' +
                    String.valueOf(value.getProductId())));


}
}
