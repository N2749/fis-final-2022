package kz.ticket.back.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository
        extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.id = ?1")
    Optional<Order> findOrder(Order order);

    @Query("SELECT o FROM Order o WHERE o.customerID = ?1")
    List<Order> findOrders(Long customerID);
}
