package kz.ticket.back.bus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BUS")
public class Bus {

    @Id
    @SequenceGenerator(
            name = "bus_sequence",
            sequenceName = "bus_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bus_sequence"
    )
    @Column
    private long id;
    @Column
    private long destinationID;
    @Column
    private long departureID;
    @Column
    private String seats;
    @Column
    private Date departureTime;
    @Column
    private Date destinationTime;

    public Bus(long destinationID, long departureID) {
        this.destinationID = destinationID;
        this.departureID = departureID;
    }

    public Bus(long destinationID, long departureID, Date departureTime, Date destinationTime) {
        this.destinationID = destinationID;
        this.departureID = departureID;
        this.departureTime = departureTime;
        this.destinationTime = destinationTime;
    }

    public Bus(long destinationID, long departureID, int numberOfSeats, Date departureTime, Date destinationTime) {
        this.destinationID = destinationID;
        this.departureID = departureID;
        this.seats = "";
        for (int i = 0; i < numberOfSeats; i++) {
            seats += "0";
        }
        this.departureTime = departureTime;
        this.destinationTime = destinationTime;
    }

    public Bus(long destinationID, long departureID, String seats, Date departureTime, Date destinationTime) {
        this.destinationID = destinationID;
        this.departureID = departureID;
        this.seats = seats;
        this.departureTime = departureTime;
        this.destinationTime = destinationTime;
    }

    public Bus(long id, long destinationID, long departureID, String seats, Date departureTime, Date destinationTime) {
        this.id = id;
        this.destinationID = destinationID;
        this.departureID = departureID;
        this.seats = seats;
        this.departureTime = departureTime;
        this.destinationTime = destinationTime;
    }

    public Bus() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(Date destinationTime) {
        this.destinationTime = destinationTime;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", destinationID=" + destinationID +
                ", departureID=" + departureID +
                ", seats=" + seats +
                ", departureTime=" + departureTime +
                ", destinationTime=" + destinationTime +
                '}';
    }
}
