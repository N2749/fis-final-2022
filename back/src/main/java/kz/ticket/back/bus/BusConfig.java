package kz.ticket.back.bus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class BusConfig {

    @Bean
    CommandLineRunner busCommandLineRunner(
            BusRepository busRepository) {
        return args -> {
            Bus bus1 = new Bus(
                    0,
                    1,
                    20,
                    new Date(),
                    new Date()
            );
            busRepository.saveAll(
                    List.of(bus1)
            );
        };
    }
}
