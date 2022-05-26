package lt.mif.flowershop.controller;

import lt.mif.flowershop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @RequestMapping("/shopping-cart/add-product/{id}")
    public String addToCart(@PathVariable("id") long itemId) {
        shoppingCartService.addItem(itemId, 1);
        return "redirect:/flowers";
    }
}
