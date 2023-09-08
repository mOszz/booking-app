package com.dlog.bookingapp.services;

import com.dlog.bookingapp.models.Vehicle;
import com.dlog.bookingapp.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehiculeRepository) {
        this.vehicleRepository = vehiculeRepository;
    }

    /**
     * Get a list of all vehicles.
     *
     * @return A list of all vehicles.
     */
    public List<Vehicle> getAllVehicules() {
        return vehicleRepository.findAll();
    }
    /**
     * Get a car by its ID.
     *
     * @param id The ID of the car to retrieve.
     * @return The vehicle with the specified ID.
     */
    public Optional<Vehicle> vehicleById(int id) {
        return vehicleRepository.findById(id);
    }
    /**
     * Updates the information of an existing car.
     *
     * @param id  The identifier of the car to update.
     * @param vehicle The vehicle containing the new information.
     * @return The updated car if it exists, or null if not found.
     */
    public Vehicle vehicleUpdate(int id, Vehicle vehicle) {
        Optional<Vehicle> existingCar = vehicleRepository.findById(id);

        if (existingCar.isPresent()) {
            Vehicle oldvehicle = existingCar.get();
            oldvehicle.setBrand(vehicle.getBrand());
            oldvehicle.setColor(vehicle.getColor());
            oldvehicle.setModel(vehicle.getModel());
            vehicleRepository.save(vehicle);
            return vehicle;
        } else {
            return null;
        }
    }

    /**
     * Deletes a car by its identifier.
     *
     * @param id The identifier of the car to delete.
     * @return An Optional containing the deleted car if it existed, or an empty Optional.
     */
    public Optional<Vehicle> vehicleDelete(int id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        vehicleRepository.deleteById(id);
        return vehicle;
    }

    /**
     * Adds a new vehicle.
     *
     * @param vehicle The new vehicle to add.
     * @return The added vehicle.
     */
    public Vehicle addACar(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return vehicle;
    }
}
