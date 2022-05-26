package lt.mif.flowershop.domain.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Flower extends Item {

    private FlowerType type;
    private int flowerNumber;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> colors = new ArrayList<>();
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> tags = new HashSet<>();

    public static Flower singleFlower(String name, String color, BigInteger price, int quantity, byte[] image, Set<String> tags) {
        return new Flower(price, quantity, name, image, FlowerType.SINGLE_FLOWER, 1, Collections.singletonList(color), tags);
    }

    public static Flower bouquet(String name, List<String> colors, int flowerCount, BigInteger price, int quantity, byte[] image, Set<String> tags) {
        return new Flower(price, quantity, name, image, FlowerType.BOUQUET, flowerCount, colors, tags);
    }

    public static Flower potFlower(String name, List<String> colors, int flowerCount, BigInteger price, int quantity, byte[] image, Set<String> tags) {
        return new Flower(price, quantity, name, image, FlowerType.FLOWER_IN_POT, flowerCount, colors, tags);
    }

    public static Flower giftCheck(BigInteger price) {
        return new Flower(price, 999, "Gift Check", new byte[0], FlowerType.GIFT_CHECK, 0, Collections.emptyList(), Collections.emptySet());
    }

    public Flower() {

    }

    public Flower(BigInteger price, int quantity, String name, byte[] image, FlowerType type, int flowerNumber, List<String> colors, Set<String> tags) {
        super(price, quantity, name, image);
        this.type = type;
        this.flowerNumber = flowerNumber;
        this.colors = colors;
        this.tags = tags;
    }

    public FlowerType getType() {
        return type;
    }

    public void setType(FlowerType type) {
        this.type = type;
    }

    public int getFlowerNumber() {
        return flowerNumber;
    }

    public void setFlowerNumber(int flowerNumber) {
        this.flowerNumber = flowerNumber;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> color) {
        this.colors = color;
    }

    public enum FlowerType {
        SINGLE_FLOWER, BOUQUET, FLOWER_IN_POT, GIFT_CHECK
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "type=" + type +
                ", flowerNumber=" + flowerNumber +
                ", colors=" + colors +
                ", tags=" + tags +
                '}';
    }
}
