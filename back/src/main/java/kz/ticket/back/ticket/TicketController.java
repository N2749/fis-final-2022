package kz.ticket.back.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/tickets")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Ticket> getTickets() {
        return ticketService.getTickets();
    }

    @PutMapping(path = "{ticketID}")
    public void updateTicket(
            @PathVariable("ticketID") Long ticketID,
            @RequestParam(required = false) Date purchaseDate,
            @RequestParam(required = false) Integer seatRow,
            @RequestParam(required = false) Integer seatColumn
            ) {
        ticketService.updateTicket(ticketID, purchaseDate, seatRow, seatColumn);
    }
}
