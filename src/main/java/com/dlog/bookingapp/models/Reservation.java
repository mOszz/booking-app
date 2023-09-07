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
}
