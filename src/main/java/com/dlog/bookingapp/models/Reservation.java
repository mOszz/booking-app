package com.dlog.bookingapp.models;

import jakarta.persistence.*;
import com.dlog.bookingapp.models.Customer;

import java.util.Calendar;

/**
 * Represents a reservation entity.
 * This class maps to the "reservation" table in the database and
 * contains information about a reservation made by a client for a vehicle.
 */
@Entity
@Table(name="reservation")
public class Reservation {
    /**
     * The unique identifier for a reservation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The vehicle associated with this reservation.
     */
    @ManyToOne
    @JoinColumn(name = "vehicule_id", referencedColumnName = "id")
    private Vehicle vehicule;
    /**
     * The customer who made the reservation.
     */
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    /**
     * The reservation starting date
     */
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar startDate;
    /**
     * The reservation ending date
     */
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar endDate;
    /**
     * Kilometer count during the reservation
     */
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
