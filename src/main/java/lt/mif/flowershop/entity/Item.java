package lt.mif.flowershop.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;

@MappedSuperclass
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private BigInteger price;
    private int quantity;
    private String name;
    @Lob
    private byte[] image;

    public Item() {
    }

    public Item(BigInteger price, int quantity, String name, byte[] image) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.image = image;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return quantity == item.quantity && Objects.equals(id, item.id) && Objects.equals(price, item.price) && Objects.equals(name, item.name) && Arrays.equals(image, item.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
