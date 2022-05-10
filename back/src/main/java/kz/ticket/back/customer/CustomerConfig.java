package kz.ticket.back.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner customerCommandLineRunner(
            CustomerRepository customerRepository) {
        return args -> {
            Customer nurbolat = new Customer(
                    "Nurbolat",
                    "n2749@gmail.com",
                    "aIsAwesome123",
                    20000
            );
            customerRepository.saveAll(
                    List.of(nurbolat)
            );
        };
    }
}
