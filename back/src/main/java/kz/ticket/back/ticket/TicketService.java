package kz.ticket.back.ticket;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    @Transactional
    public void updateTicket(Long ticketID, Date purchaseDate, Integer seatRow, Integer seatColumn) {

        Ticket ticket = ticketRepository.findById(ticketID)
                .orElseThrow(() -> new IllegalArgumentException(
                        "ticket with id " + ticketID + "does not exist"));
        if ((purchaseDate != null) && (purchaseDate.getTime() > 0L) ) {
            ticket.setPurchaseDate(purchaseDate);
        }

        if (seatRow != null) {
            ticket.setSeatRow(seatRow);
        }

        if (seatColumn != null) {
            ticket.setSeatColumn(seatColumn);
        }
    }
}
