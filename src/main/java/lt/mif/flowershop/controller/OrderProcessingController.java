package lt.mif.flowershop.controller;


import lt.mif.flowershop.domain.OrderInformation;
import lt.mif.flowershop.domain.OrderInvoice;
import lt.mif.flowershop.service.OrderProcessingService;
import lt.mif.flowershop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Controller
@SessionScope
@RequestMapping("/order")
public class OrderProcessingController {

    private final OrderProcessingService checkoutProcessingService;
    private final ShoppingCartService shoppingCartService;

    private Future<OrderInvoice> invoice = null;

    @Autowired
    public OrderProcessingController(OrderProcessingService checkoutProcessingService, ShoppingCartService shoppingCartService) {
        this.checkoutProcessingService = checkoutProcessingService;
        this.shoppingCartService = shoppingCartService;
    }

    @RequestMapping("/invoice")
    public String renderInvoice() {
        return "invoice";
    }

    @PostMapping
    public String processCheckout(OrderInformation orderInformation) {
        invoice = checkoutProcessingService.processOrder(orderInformation, shoppingCartService.getCart());
        return "redirect:order/invoice";
    }

    @ModelAttribute("processing")
    public boolean isProcessing() {
        return invoice != null && !invoice.isDone();
    }

    @ModelAttribute("processed")
    public boolean isProcessed() {
        return invoice != null && invoice.isDone();
    }

    @ModelAttribute("invoice")
    public OrderInvoice getInvoice() {
        if (isProcessed()) {
            try {
                return invoice.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Failed to process checkout");
            }
        } else {
            return null;
        }
    }

}
