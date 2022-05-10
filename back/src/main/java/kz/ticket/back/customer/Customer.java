package kz.ticket.back.customer;

import javax.persistence.*;

@Entity
@Table(name="CUSTOMER")
public class    Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    @Column

    private long id;
    @Column
    private String name;

    @Column
    private String email;
    @Column
    private String password;

    @Column
    private double balance;

    public Customer() {
    }

    public Customer(String name, String email, String password, double balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public Customer(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Customer(long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Customer(long id, String name, String email, String password, double balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
