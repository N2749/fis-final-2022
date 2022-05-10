package kz.ticket.back.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/buses")
public class BusController {
    private final BusService busService;

    @Autowired
    public BusController(BusService busService) {
        this.busService = busService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Bus> getBuses() {
        return busService.getBuses();
    }

    @PutMapping(path = "{busID}")
    public void updateCustomer(
            @PathVariable("busID") Long busID,
            @RequestParam(required = false) String seats) {
        busService.updateBus(busID, seats);
    }
}
