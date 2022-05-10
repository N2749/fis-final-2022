package kz.ticket.back.ticket;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TICKET")
public class Ticket {
    @Id
    @SequenceGenerator(
            name = "ticket_sequence",
            sequenceName = "ticket_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ticket_sequence"
    )
    @Column
    private long id;
    @Column
    private long customerID;
    @Column
    private long destinationID;
    @Column
    private long departureID;
    @Column
    private long busID;
    @Column
    private Date purchaseDate;
    @Column
    private Date expirationDate;
    @Column
    private double price;
    @Column
    private int seatRow;
    @Column
    private int seatColumn;

    public Ticket(long destinationID, long departureID, long busID, Date expirationDate, double price) {
        this.destinationID = destinationID;
        this.departureID = departureID;
        this.busID = busID;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    public Ticket(long id, long destinationID, long departureID, long busID, Date expirationDate, double price) {
        this.id = id;
        this.destinationID = destinationID;
        this.departureID = departureID;
        this.busID = busID;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    public Ticket(long customerID, long destinationID, long departureID, long busID, Date purchaseDate, Date expirationDate, double price, int seatRow, int seatColumn) {
        this.customerID = customerID;
        this.destinationID = destinationID;
        this.departureID = departureID;
        this.busID = busID;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.price = price;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
    }

    public Ticket(long id, long customerID, long destinationID, long departureID, long busID, Date purchaseDate, Date expirationDate, double price, int seatRow, int seatColumn) {
        this.id = id;
        this.customerID = customerID;
        this.destinationID = destinationID;
        this.departureID = departureID;
        this.busID = busID;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.price = price;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
    }

    public Ticket() {

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

    public long getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(long destinationID) {
        this.destinationID = destinationID;
    }

    public long getDepartureID() {
        return departureID;
    }

    public void setDepartureID(long departureID) {
        this.departureID = departureID;
    }

    public long getBusID() {
        return busID;
    }

    public void setBusID(long busID) {
        this.busID = busID;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int row) {
        this.seatRow = row;
    }

    public int getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(int seatColumn) {
        this.seatColumn = seatColumn;
    }
}
