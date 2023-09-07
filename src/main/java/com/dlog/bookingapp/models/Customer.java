package com.dlog.bookingapp.models;

import jakarta.persistence.*;

import java.util.Calendar;

/**
 * Represents a client entity.
 * This class maps to the "client" table in the database and
 * contains information about a client who may make reservations.
 */
@Entity
@Table(name="customer")
public class Customer {
    /**
     * The unique identifier for a client.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    /**
     * The last name of the client.
     */
    @Column(length = 50, nullable = false)
    private String lastName;
    /**
     * The first name of the client.
     */
    @Column(length = 50, nullable = false)
    private String firstName;
    /**
     * The birthdate of the client.
     */
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar birthDate;
    /**
     * The driving license number of the client, if available.
     */
    @Column(nullable = true)
    private int drivingLicence;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public int getDrivingLicence() {
        return drivingLicence;
    }

    public void setDrivingLicence(int drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", drivingLicence=" + drivingLicence +
                '}';
    }
}
