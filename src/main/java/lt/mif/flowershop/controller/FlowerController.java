package lt.mif.flowershop.controller;

import lt.mif.flowershop.domain.entity.Flower;
import lt.mif.flowershop.domain.MoodDefinition;
import lt.mif.flowershop.service.FlowerService;
import lt.mif.flowershop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/flowers")
public class FlowerController {

    private final FlowerService flowerService;
    private final ShoppingCartService shoppingCartService;
    private List<Flower> moodFlowers = null;


    @Autowired
    public FlowerController(FlowerService flowerService, ShoppingCartService shoppingCartService) {
        this.flowerService = flowerService;
        this.shoppingCartService = shoppingCartService;
    }

    @ModelAttribute("cart")
    public ShoppingCartService cart() {
        return this.shoppingCartService;
    }

    @ModelAttribute("bouquets")
    public List<Flower> bouquets() {
        return this.flowerService.getBouquets();
    }

    @ModelAttribute("potFlowers")
    public List<Flower> potFlowers() {
        return this.flowerService.getPotFlowers();
    }

    @ModelAttribute("singleFlowers")
    public List<Flower> singleFlowers() {
        return this.flowerService.getSingleFlowers();
    }

    @ModelAttribute("moodFlowers")
    public List<Flower> moodFlowers() {
        return moodFlowers;
    }

    @RequestMapping()
    public String showFlowers() {
        return "flowers";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String searchByMood(MoodDefinition moodDefinition) {
        moodFlowers = flowerService.searchFlowers(moodDefinition);
        return "redirect:/flowers";
    }

    @RequestMapping("/reset-mood")
    public String showAllFlowers() {
        moodFlowers = null;
        return "redirect:/flowers";
    }
}
