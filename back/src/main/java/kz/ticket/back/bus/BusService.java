package kz.ticket.back.bus;

import kz.ticket.back.customer.Customer;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BusService {

    private final BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public List<Bus> getBuses(){
        return busRepository.findAll();
    }

    public void updateBus(long busID,
                          String seats) {
        Bus bus = busRepository.findById(busID)
                .orElseThrow(() -> new IllegalStateException(
                        "bus with id " + busID + " does not exist"));

        if ((seats != null)) {

        }
    }
}
