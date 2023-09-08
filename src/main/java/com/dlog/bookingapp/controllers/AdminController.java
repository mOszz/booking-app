package com.dlog.bookingapp.controllers;

import com.dlog.bookingapp.models.Reservation;
import com.dlog.bookingapp.models.Vehicle;
import com.dlog.bookingapp.services.ReservationService;
import com.dlog.bookingapp.services.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")

public class AdminController {

    private final VehicleService vehicleService;
    private final ReservationService reservationService;


    public AdminController(VehicleService vehicleService, ReservationService reservationService) {
        this.vehicleService = vehicleService;
        this.reservationService = reservationService;
    }


    @GetMapping("vehicles")
    public ResponseEntity<List<Vehicle>>getAllVehicules(){
        return ResponseEntity.ok(vehicleService.getAllVehicules());
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<Optional<Vehicle>> fillById(@PathVariable int id){
        return ResponseEntity.ok(vehicleService.vehicleById(id));
    }


    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<Optional<Vehicle>> deleteVehicle(@PathVariable int id){
        return ResponseEntity.ok(vehicleService.vehicleDelete(id));
    }

    @PutMapping("/vehicles/{id}")
    public ResponseEntity<String> carUpdate(@PathVariable int id, @RequestBody Vehicle vehicle) {
        Vehicle updatedCar = vehicleService.vehicleUpdate(id, vehicle);
        return ResponseEntity.ok("Car "+ updatedCar.getId()+" was successfully updated");
    }
    @PostMapping("/vehicles")
        public ResponseEntity<String> addACar(@RequestBody Vehicle vehicle) {
        Vehicle newVehicle = vehicleService.addACar(vehicle);
        return ResponseEntity.ok("Car "+ newVehicle.getId() +" added successfully");
    }

    @DeleteMapping("/reservation/{id}")
    public ResponseEntity<Optional<Reservation>> deleteReservation(@PathVariable int id){
        return ResponseEntity.ok(reservationService.deleteReservation(id));
    }
    @PutMapping("/reservation/{id}")
    public ResponseEntity<String> updateReservation(@PathVariable int id, @RequestBody Reservation reservation){
        Reservation updatedReservation = reservationService.reservationUpdate(id, reservation);
        return ResponseEntity.ok("reservation "+ updatedReservation.getId() +" was successfully updated");
    }
}
