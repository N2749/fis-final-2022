package kz.ticket.back.station;

import kz.ticket.back.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StationRepository
        extends JpaRepository<Station, Long> {

    @Query("SELECT s FROM Station s WHERE s.location =?1")
    Optional<Station> findStationByLocation(String Location);

}
