package lt.mif.flowershop.controller;

import lt.mif.flowershop.domain.entity.Flower;
import lt.mif.flowershop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @RequestMapping("/add-product/{id}")
    public String addToCart(@PathVariable("id") long itemId) {
        shoppingCartService.addItem(itemId, 1);
        return "redirect:/flowers";
    }

    @RequestMapping
    public String showCart() {
        return "cart";
    }

    @ModelAttribute("cart")
    public Set<Map.Entry<Flower, Integer>> moodFlowers() {
        return shoppingCartService.getCart().entrySet();
    }
}
