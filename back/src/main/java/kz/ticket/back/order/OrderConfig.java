package kz.ticket.back.order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OrderConfig {

    @Bean
    CommandLineRunner orderCommandLineRunner(
            OrderRepository orderRepository) {
        return args -> {
            Order order1 = new Order(
                    0,
                    0
            );
            orderRepository.saveAll(
                    List.of(
                            order1
                    )
            );
        };
    }
}
