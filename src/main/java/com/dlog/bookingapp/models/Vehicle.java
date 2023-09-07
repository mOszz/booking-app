package com.dlog.bookingapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Vehicle {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(nullable = false)
    private int taxHorsePower;
    @Column(nullable = false, length = 50)
    private String model ;
    @Column(nullable = false, length = 50)
    private String brand;
    @Column(nullable = false, length = 50)
    private String color;
    @Column(nullable = false, length = 12, unique = true)
    private String registration;
    @Column(nullable = false)
    private float priceDay;
    @Column(nullable = false)
    private float priceKm;


    public Vehicle(){

    }
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
