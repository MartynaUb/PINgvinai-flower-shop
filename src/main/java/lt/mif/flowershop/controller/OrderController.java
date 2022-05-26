package lt.mif.flowershop.controller;

import lt.mif.flowershop.domain.OrderInformation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @ModelAttribute("order")
    public OrderInformation order() {
        return new OrderInformation();
    }

    @GetMapping
    public String fillOrder() {
        return "order";
    }
}
