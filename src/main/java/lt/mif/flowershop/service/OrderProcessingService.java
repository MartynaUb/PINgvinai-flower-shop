package lt.mif.flowershop.service;

import lt.mif.flowershop.domain.OrderInformation;
import lt.mif.flowershop.domain.OrderInvoice;
import lt.mif.flowershop.domain.entity.Flower;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
public class OrderProcessingService {


    public Future<OrderInvoice> processOrder(OrderInformation orderInformation, Map<Flower, Integer> cart) {
        return CompletableFuture.supplyAsync(() -> {
            var totalPrice = cart.entrySet().stream()
                    .map(entry -> entry.getKey().getPrice().multiply(BigInteger.valueOf(entry.getValue())))
                    .reduce(BigInteger.ZERO, BigInteger::add);
            var itemDefinitions = cart.entrySet().stream().map(entry -> {
                var flower = entry.getKey();
                return flower.getName() + " Price: " + flower.getPrice() + " Count: " + entry.getValue() + " Total price: " + flower.getPrice().multiply(BigInteger.valueOf(entry.getValue()));
            }).collect(Collectors.toList());

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {

            }

            return new OrderInvoice(orderInformation, totalPrice, LocalDateTime.now().plusDays(5), itemDefinitions);
        });
    }
}
