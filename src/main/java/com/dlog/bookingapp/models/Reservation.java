package com.dlog.bookingapp.models;

import jakarta.persistence.*;
import com.dlog.bookingapp.models.Customer;

@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    private Long id;
    // Clé étrangère vers Vehicule
    @ManyToOne
    @JoinColumn(name = "vehicule_id", referencedColumnName = "id")
    private Vehicle vehicule;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Customer customer;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
