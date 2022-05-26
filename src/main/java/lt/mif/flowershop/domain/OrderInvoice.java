package lt.mif.flowershop.domain;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

public class OrderInvoice {

    private OrderInformation orderInformation;
    private BigInteger totalPrice;
    private LocalDateTime expectedDate;
    private List<String> itemDefinitions;

    public OrderInvoice(OrderInformation orderInformation, BigInteger totalPrice, LocalDateTime expectedDate, List<String> itemDefinitions) {
        this.orderInformation = orderInformation;
        this.totalPrice = totalPrice;
        this.expectedDate = expectedDate;
        this.itemDefinitions = itemDefinitions;
    }

    public BigInteger getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigInteger totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(LocalDateTime expectedDate) {
        this.expectedDate = expectedDate;
    }

    public List<String> getItemDefinitions() {
        return itemDefinitions;
    }

    public void setItemDefinitions(List<String> itemDefinitions) {
        this.itemDefinitions = itemDefinitions;
    }

    public OrderInformation getOrderInformation() {
        return orderInformation;
    }

    public void setOrderInformation(OrderInformation orderInformation) {
        this.orderInformation = orderInformation;
    }

    @Override
    public String toString() {
        return "OrderInvoice{" +
                "orderInformation=" + orderInformation +
                ", totalPrice=" + totalPrice +
                ", expectedDate=" + expectedDate +
                ", itemDefinitions=" + itemDefinitions +
                '}';
    }
}
