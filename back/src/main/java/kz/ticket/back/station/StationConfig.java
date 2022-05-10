package kz.ticket.back.station;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StationConfig {

    @Bean
    CommandLineRunner stationCommandLineRunner(
            StationRepository repository) {
        return args -> {
            Station sairan = new Station(
                    "Sairan",
                    "Almaty"
            );
            Station notSairan = new Station(
                    "Not Sairan",
                    "Taraz"
            );
            repository.saveAll(
                    List.of(sairan, notSairan)
            );
        };
    }
}
