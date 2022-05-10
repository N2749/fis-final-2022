package kz.ticket.back.ticket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository
        extends JpaRepository<Ticket, Long> {
}
