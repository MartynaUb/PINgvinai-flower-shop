package lt.mif.flowershop.service;

import lt.mif.flowershop.domain.entity.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Component
@SessionScope
public class ShoppingCartService {

    private final FlowerService flowerService;

    @Autowired
    public ShoppingCartService(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    private final Map<Flower, Integer> cart = new HashMap<>();

    public void addItem(long flowerId, int quantity) {
        var flower = flowerService.getFlower(flowerId);
        var currentQuantity = cart.getOrDefault(flower, 0);
        cart.put(flower, currentQuantity + quantity);
    }

    public int count() {
        return cart.values().stream().mapToInt(integer -> integer).sum();
    }

    public BigInteger price() {
        return cart.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigInteger.valueOf(entry.getValue())))
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    public Map<Flower, Integer> getCart() {
        return new HashMap<>(cart);
    }

    public void reset() {
        cart.keySet().clear();
    }
}
