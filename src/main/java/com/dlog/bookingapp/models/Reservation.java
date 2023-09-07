package com.dlog.bookingapp.models;

import jakarta.persistence.*;
import com.dlog.bookingapp.models.Customer;

import java.util.Calendar;

@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "vehicule_id", referencedColumnName = "id")
    @Column(nullable = false)
    private Vehicle vehicule;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @Column(nullable = false)
    private Customer customer;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar startDate;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar endDate;
    @Column(nullable = false)
    private int kmCount;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Vehicle getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicle vehicule) {
        this.vehicule = vehicule;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public int getKmCount() {
        return kmCount;
    }

    public void setKmCount(int kmCount) {
        this.kmCount = kmCount;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", vehicule=" + vehicule +
                ", customer=" + customer +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", kmCount=" + kmCount +
                '}';
    }
}
