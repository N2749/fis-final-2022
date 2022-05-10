package kz.ticket.back.order;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrders(Long customerID) {
        return orderRepository.findOrders(customerID);
    }

    public void addNewOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(Long orderID) {
        orderRepository.deleteById(orderID);
    }
}
