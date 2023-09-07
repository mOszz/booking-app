package com.dlog.bookingapp.models;

import jakarta.persistence.*;

import java.util.Calendar;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String lastName;
    @Column(length = 50, nullable = false)
    private String firstName;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar birthDate;
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
