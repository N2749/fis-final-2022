package kz.ticket.back.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public void postOrder(@RequestBody Order order) {
        orderService.addNewOrder(order);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(path = "{orderID}")
    public void deleteOrder(
            @PathVariable("orderID") Long orderID) {
        orderService.deleteOrder(orderID);
    }

}
