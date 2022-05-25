package lt.mif.flowershop.controller;

import lt.mif.flowershop.entity.MoodDefinition;
import lt.mif.flowershop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MoodBuilderController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public MoodBuilderController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @ModelAttribute("cart")
    public ShoppingCartService cart() {
        return this.shoppingCartService;
    }

    @ModelAttribute("moodDefinition")
    public MoodDefinition moodDefinition() {
        return new MoodDefinition();
    }

    @RequestMapping("/mood-builder")
    public String buildMood() {
        return "mood-builder";
    }
}
