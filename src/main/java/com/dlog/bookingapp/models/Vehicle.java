/**
 * Represents the Vehicle entity within the booking app system.
 *
 * @author [Your Name]
 * @version 1.0
 * @since [Date of Creation]
 */
package com.dlog.bookingapp.models;

import jakarta.persistence.*;

@Entity
@Table(name="vehicle")
public class Vehicle {

    /**
     * Unique identifier for the vehicle.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    /**
     * Tax horsepower of the vehicle.
     */
    @Column(nullable = false)
    private int taxHorsePower;

    /**
     * Model name of the vehicle.
     */
    @Column(nullable = false, length = 50)
    private String model;

    /**
     * Brand name of the vehicle.
     */
    @Column(nullable = false, length = 50)
    private String brand;

    /**
     * Color of the vehicle.
     */
    @Column(nullable = false, length = 50)
    private String color;

    /**
     * Unique registration number of the vehicle.
     */
    @Column(nullable = false, length = 12, unique = true)
    private String registration;

    /**
     * Rental price of the vehicle per day.
     */
    @Column(nullable = false)
    private float priceDay;

    /**
     * Rental price of the vehicle per kilometer.
     */
    @Column(nullable = false)
    private float priceKm;

    /**
     * Default constructor.
     */
    public Vehicle(){

    }

    /**
     * Parameterized constructor to initialize all properties of the vehicle.
     *
     * @param id Unique identifier for the vehicle.
     * @param taxHorsePower Tax horsepower of the vehicle.
     * @param model Model name of the vehicle.
     * @param brand Brand name of the vehicle.
     * @param color Color of the vehicle.
     * @param registration Unique registration number of the vehicle.
     * @param priceDay Rental price of the vehicle per day.
     * @param priceKm Rental price of the vehicle per kilometer.
     */
    public Vehicle(int id, int taxHorsePower, String model, String brand, String color, String registration, float priceDay, float priceKm) {
        this.id = id;
        this.taxHorsePower = taxHorsePower;
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.registration = registration;
        this.priceDay = priceDay;
        this.priceKm = priceKm;
    }

    /**
     * Returns a string representation of the vehicle.
     *
     * @return a string representation of the vehicle.
     */

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", taxHorsePower=" + taxHorsePower +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", registration='" + registration + '\'' +
                ", priceDay=" + priceDay +
                ", priceKm=" + priceKm +
                '}';
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTaxHorsePower() {
        return taxHorsePower;
    }

    public void setTaxHorsePower(int taxHorsePower) {
        this.taxHorsePower = taxHorsePower;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public float getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(float priceDay) {
        this.priceDay = priceDay;
    }

    public float getPriceKm() {
        return priceKm;
    }

    public void setPriceKm(float priceKm) {
        this.priceKm = priceKm;
    }
}
