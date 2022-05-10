package kz.ticket.back.station;


import javax.persistence.*;

@Table(name="STATION")
@Entity
public class Station {
    @Id
    @SequenceGenerator(
            name = "station_sequence",
            sequenceName = "station_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "station_sequence"
    )
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String location;

    public Station() {
    }

    public Station(Long id,
                   String name,
                   String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Station(String name,
                   String location) {
        this.name = name;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}


