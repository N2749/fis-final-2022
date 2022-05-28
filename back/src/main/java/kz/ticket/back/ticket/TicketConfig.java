package kz.ticket.back.ticket;

import kz.ticket.back.bus.Bus;
import kz.ticket.back.customer.Customer;
import kz.ticket.back.station.Station;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class TicketConfig {
    @Bean
    CommandLineRunner ticketCommandLineRunner(TicketRepository ticketRepository) {
        return args -> {
            Ticket ticket1 = new Ticket(
                    2,
                    1,
                    0,
                    new Date(new Date().getTime() + 1000 * 60 * 60 * 24 * 5L),
                    5000D
            );

            ticketRepository.saveAll(
                    List.of(
                            ticket1
                    )
            );
        };
    }
}
