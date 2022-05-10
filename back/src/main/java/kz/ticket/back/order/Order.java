package kz.ticket.back.order;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS_HISTORY")
public class Order {
    @Id
    @SequenceGenerator(
            name = "orders_history_sequence",
            sequenceName = "orders_history_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orders_history_sequence"
    )
    @Column
    private long id;
    @Column
    private long customerID;
    @Column
    private long ticketID;

    public Order(long id, long customerID, long ticketID) {
        this.id = id;
        this.customerID = customerID;
        this.ticketID = ticketID;
    }

    public Order(long customerID, long ticketID) {
        this.customerID = customerID;
        this.ticketID = ticketID;
    }

    public Order() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public long getTicketID() {
        return ticketID;
    }

    public void setTicketID(long ticketID) {
        this.ticketID = ticketID;
    }
}
